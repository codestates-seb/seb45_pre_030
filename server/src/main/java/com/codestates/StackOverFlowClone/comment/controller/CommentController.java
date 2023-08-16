package com.codestates.StackOverFlowClone.comment.controller;

import com.codestates.StackOverFlowClone.comment.dto.CommentDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.comment.mapper.CommentMapper;
import com.codestates.StackOverFlowClone.comment.service.CommentService;
import com.codestates.StackOverFlowClone.response.SingleResponseDto;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequestMapping("/question/{question-id}/reply/{reply-id}/comment")
@Validated
public class CommentController {
    private final static String COMMENT_DEFAULT_URL = "/question/{question-id}/reply/{reply-id}/comment";
    private final CommentService commentService;
    private  final CommentMapper mapper;

    public CommentController(CommentService commentService, CommentMapper mapper) {
        this.commentService = commentService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postComment(@Valid @RequestBody CommentDto.Post requestBody,  @PathVariable("reply-id") @Positive long replyId) {
        requestBody.setReplyId(replyId);
        Comment comment = mapper.CommentPostDtoToComment(requestBody);
        Comment response = commentService.createComment(comment);

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.commentToCommentResponseDto(response)), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getComments(@PathVariable("question-id") @Positive long questionId, @PathVariable("reply-id") @Positive long replyId) {
        return new ResponseEntity<>(mapper.CommentsToCommentsResponseDto(commentService.findCommentsInReply(replyId)),HttpStatus.OK);
    }
}
