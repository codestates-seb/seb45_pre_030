package com.codestates.StackOverFlowClone.comment.controller;

import com.codestates.StackOverFlowClone.comment.dto.CommentDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.comment.mapper.CommentMapper;
import com.codestates.StackOverFlowClone.comment.service.CommentService;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.response.SingleResponseDto;
import com.codestates.StackOverFlowClone.utils.UriCreator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/question/{question-id}/reply/{reply-id}/comment")
@Validated
public class CommentController {
    private final static String COMMENT_DEFAULT_URL = "/question/{question-id}/reply/{reply-id}/comment";
    private final CommentService commentService;
    private final CommentMapper mapper;

    public CommentController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentDto.Post requestBody,
                                      @PathVariable("question-id") @Positive long questionId,@PathVariable("reply-id") @Positive long replyId) {
        requestBody.setReplyId(replyId);
        Comment comment = mapper.commentPostDtoToComment(requestBody);
        Comment response = commentService.createComment(comment);
        URI location = UriComponentsBuilder
                .newInstance()
                .path(COMMENT_DEFAULT_URL + "/{comment-id}")
                .buildAndExpand(questionId,replyId, response.getCommentId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @PatchMapping("{comment-id}")
    public ResponseEntity patchComment(@Valid @RequestBody CommentDto.Patch requestBody, @PathVariable("reply-id") @Positive long replyId,
                                       @PathVariable("comment-id") @Positive long commentId) {
        requestBody.setCommentId(commentId);
        requestBody.setReplyId(replyId);
        Comment comment = commentService.updateComment(mapper.commentPatchDtoToComment(requestBody));

        return new ResponseEntity<>(mapper.commentToCommentResponseDto(comment),HttpStatus.OK);
    }

    @GetMapping("/{comment-id}")
    public ResponseEntity getComment(@PathVariable("comment-id") @Positive long commentId) {
        Comment comment = commentService.findComment(commentId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(comment)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getComments(@PathVariable("question-id") @Positive long questionId, @PathVariable("reply-id") @Positive long replyId) {
        return new ResponseEntity<>(mapper.commentsToCommentsResponseDto(commentService.findCommentsInReply(replyId)), HttpStatus.OK);
    }

    @DeleteMapping("/{comment-id}")
    public void deleteComment(@PathVariable("comment-id")@Positive long commentId){
        commentService.deleteComment(commentId);
    }
}
