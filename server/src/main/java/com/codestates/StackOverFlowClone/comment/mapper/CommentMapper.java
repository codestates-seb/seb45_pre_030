package com.codestates.StackOverFlowClone.comment.mapper;

import com.codestates.StackOverFlowClone.comment.dto.CommentDto;
import com.codestates.StackOverFlowClone.comment.dto.CommentResponseDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
@Component
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "replyId", target = "reply.replyId")
    Comment CommentPostDtoToComment(CommentDto.Post commentPostDto);
    @Mapping(source = "replyId", target = "reply.replyId")
    Comment CommentPatchDtoToComment(CommentDto.Patch commentPatchDto);

    default CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if (comment == null) {
            return null;
        }

        long commentId = comment.getCommentId();
        long replyId = comment.getReply().getReplyId();

        String CommentContent = comment.getContent();
        LocalDateTime createdAt = comment.getCreatedAt();

        CommentResponseDto response = new CommentResponseDto(
                commentId, replyId, CommentContent, createdAt);

        return response;
    }
    List<CommentResponseDto> CommentsToCommentsResponseDto(List<Comment> comments);


}
