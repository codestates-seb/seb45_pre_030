package com.codestates.StackOverFlowClone.comment.mapper;

import com.codestates.StackOverFlowClone.comment.dto.CommentDto;
import com.codestates.StackOverFlowClone.comment.dto.CommentResponseDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;
import java.util.List;
@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(source = "replyId", target = "reply.replyId")
    @Mapping(source="memberId", target ="member.memberId")
    Comment commentPostDtoToComment(CommentDto.Post commentPostDto);
    @Mapping(source = "replyId", target = "reply.replyId")
    Comment commentPatchDtoToComment(CommentDto.Patch commentPatchDto);

    default CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if (comment == null) {
            return null;
        }

        long commentId = comment.getCommentId();
        long replyId = comment.getReply().getReplyId();
        long memberId = comment.getMember().getMemberId();
        String memberName = comment.getMember().getName();
        String CommentContent = comment.getContent();
        LocalDateTime createdAt = comment.getCreatedAt();

        CommentResponseDto response = new CommentResponseDto(
                commentId, replyId, memberId, memberName, CommentContent, createdAt);

        return response;
    }
    List<CommentResponseDto> commentsToCommentsResponseDto(List<Comment> comments);

}
