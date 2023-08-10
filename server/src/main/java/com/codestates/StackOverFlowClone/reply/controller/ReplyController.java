package com.codestates.StackOverFlowClone.reply.controller;

import com.codestates.StackOverFlowClone.reply.dto.ReplyPatchDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyPostDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import com.codestates.StackOverFlowClone.reply.mapper.ReplyMapper;
import com.codestates.StackOverFlowClone.reply.service.ReplyService;
import com.codestates.StackOverFlowClone.response.SingleResponseDto;
import com.codestates.StackOverFlowClone.utils.UriCreator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.net.URI;

@RestController
@RequestMapping("/reply")
@Validated
public class ReplyController {
    private final static String REPLY_DEFAULT_URL = "/reply";
    private final ReplyService replyService;
    private final ReplyMapper mapper;

    public ReplyController(ReplyService replyService, ReplyMapper mapper) {
        this.replyService = replyService;
        this.mapper = mapper;
    }
    @PostMapping
    public ResponseEntity postReply(@Valid @RequestBody ReplyPostDto requestBody) {
        Reply reply = mapper.ReplyPostDtoToReply(requestBody);

        Reply createdReply = replyService.createReply(reply);
        URI location = UriCreator.createUri(REPLY_DEFAULT_URL, createdReply.getReplyId());

        return ResponseEntity.created(location).build();
    }

    @PatchMapping("/{reply-id}")
    public ResponseEntity patchReply(@PathVariable("reply-id") @Positive long replyId,
                                     @Valid @RequestBody ReplyPatchDto requestBody) {
        requestBody.setReplyId(replyId);

        Reply reply = replyService.updateReply(mapper.ReplyPatchDtoToReply(requestBody));

        return new ResponseEntity<>(new SingleResponseDto<>(mapper.ReplyToReplyResponseDto(reply)), HttpStatus.OK);
    }

    @GetMapping("/{reply-id}")
    public ResponseEntity getReply(@PathVariable("reply-id") @Positive long replyId) {
        Reply reply = replyService.findReply(replyId);
        return new ResponseEntity<>(new SingleResponseDto<>(mapper.ReplyToReplyResponseDto(reply)),HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getReplies() {
        return new ResponseEntity<>(mapper.RepliesToReplyResponseDtos(replyService.findReplies()),HttpStatus.OK);
    }

    @DeleteMapping("/{reply-id}")
    public ResponseEntity deleteReply(@PathVariable("reply-id") @Positive long replyId) {
        replyService.deleteReply(replyId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
