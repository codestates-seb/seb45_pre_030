package com.codestates.StackOverFlowClone.reply.controller;

import com.codestates.StackOverFlowClone.reply.dto.ReplyDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPatchDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPostDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.reply.mapper.ReplyMapper;
import com.codestates.StackOverFlowClone.reply.service.ReplyService;
import com.codestates.StackOverFlowClone.response.SingleResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/question/{question-id}/reply")
@Validated
public class ReplyController {
    private final static String REPLY_DEFAULT_URL = "/question/{question-id}/reply";
    private final ReplyService replyService;
    private final ReplyMapper mapper;

    public ReplyController(ReplyService replyService, ReplyMapper mapper) {
        this.replyService = replyService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postReply(@PathVariable("question-id") @Positive long questionId,
                                    @Valid @RequestBody ReplyDto.Post requestBody) {
        requestBody.setQuestionId(questionId);
        Reply reply = mapper.ReplyPostDtoToReply(requestBody);

        Reply createdReply = replyService.createReply(reply);
        URI location = UriComponentsBuilder
                .newInstance()
                .path(REPLY_DEFAULT_URL + "/{reply-id}")
                .buildAndExpand(questionId, createdReply.getReplyId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{reply-id}")
    public ResponseEntity patchReply(@PathVariable("question-id") @Positive long questionId,
                                     @PathVariable("reply-id") @Positive long replyId,
                                     @Valid @RequestBody ReplyDto.Patch requestBody) {
        requestBody.setReplyId(replyId);
        requestBody.setQuestionId(questionId);


        Reply reply = replyService.updateReply(mapper.ReplyPatchDtoToReply(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.ReplyToReplyResponseDto(reply)), HttpStatus.OK);
    }

    @PatchMapping("{reply-id}/choice")
    public ResponseEntity patchReplyChoice(@PathVariable("question-id") @Positive long questionId,
                                           @PathVariable("reply-id") @Positive long replyId,
                                           @Valid @RequestBody ReplyDto.Patch requestBody) {
        requestBody.setReplyId(replyId);
        requestBody.setQuestionId(questionId);

        Reply reply = mapper.ReplyPatchDtoToReply(requestBody);

        Reply choicedReply = replyService.updateReplyChoice(reply);

        System.out.println("choice reply : "+choicedReply.getChoice());

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.ReplyToReplyResponseDto(choicedReply)), HttpStatus.OK);
    }

    @GetMapping("/{reply-id}")
    public ResponseEntity getReply(@PathVariable("reply-id") @Positive long replyId) {
        Reply reply = replyService.findReply(replyId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.ReplyToReplyResponseDto(reply)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getReplies(@PathVariable("question-id") @Positive long questionId) {
        return new ResponseEntity<>(mapper.RepliesToReplyResponseDtos(replyService.findQuestionReplies(questionId)),HttpStatus.OK);
    }

    @DeleteMapping("/{reply-id}")
    public ResponseEntity deleteReply(@PathVariable("reply-id") @Positive long replyId) {
        replyService.deleteReply(replyId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
