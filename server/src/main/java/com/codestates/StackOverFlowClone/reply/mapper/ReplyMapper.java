package com.codestates.StackOverFlowClone.reply.mapper;

import com.codestates.StackOverFlowClone.comment.dto.CommentResponseDto;
import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.question.mapper.QuestionMapper;
import com.codestates.StackOverFlowClone.reply.dto.ReplyDto;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
@Mapper(componentModel = "spring")
public interface ReplyMapper {

    @Mapping(source = "questionId", target = "question.questionId")
    Reply ReplyPostDtoToReply(ReplyDto.Post replyPostDto);
    @Mapping(source = "questionId", target = "question.questionId")
    Reply ReplyPatchDtoToReply(ReplyDto.Patch replyPatchDto);
//    @Mapping(source = "question.questionId", target = "questionId")
//    ReplyResponseDto ReplyToReplyResponseDto(Reply reply);
//    List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies);


    default public ReplyResponseDto ReplyToReplyResponseDto(Reply reply) {
        if ( reply == null ) {
            return null;
        }

        ReplyResponseDto.ReplyResponseDtoBuilder replyResponseDto = ReplyResponseDto.builder();

        replyResponseDto.questionId( replyQuestionQuestionId( reply ) );
        replyResponseDto.replyId( reply.getReplyId() );
        replyResponseDto.memberId( reply.getMemberId() );
        replyResponseDto.content( reply.getContent() );
        replyResponseDto.createdAt( reply.getCreatedAt() );
        replyResponseDto.choice(reply.getChoice());
        replyResponseDto.comments( commentListToCommentResponseDtoList( reply.getComments() ) );

        return replyResponseDto.build();
    }

    default public List<ReplyResponseDto> RepliesToReplyResponseDtos(List<Reply> replies) {
        if ( replies == null ) {
            return null;
        }

        List<ReplyResponseDto> list = new ArrayList<>( replies.size() );
        for ( Reply reply : replies ) {
            list.add( ReplyToReplyResponseDto( reply ) );
        }

        return list;
    }

    private long replyQuestionQuestionId(Reply reply) {
        if ( reply == null ) {
            return 0L;
        }
        Question question = reply.getQuestion();
        if ( question == null ) {
            return 0L;
        }
        long questionId = question.getQuestionId();
        return questionId;
    }

    default CommentResponseDto commentToCommentResponseDto(Comment comment) {
        if ( comment == null ) {
            return null;
        }

        CommentResponseDto.CommentResponseDtoBuilder commentResponseDto = CommentResponseDto.builder();

        commentResponseDto.commentId( comment.getCommentId() );
        commentResponseDto.content( comment.getContent() );
        commentResponseDto.memberId(comment.getMemberId());
        commentResponseDto.replyId(comment.getReply().getReplyId());
        commentResponseDto.createdAt( comment.getCreatedAt() );

        return commentResponseDto.build();
    }

    default List<CommentResponseDto> commentListToCommentResponseDtoList(List<Comment> list) {
        if ( list == null ) {
            return null;
        }

        List<CommentResponseDto> list1 = new ArrayList<>( list.size() );
        for ( Comment comment : list ) {
            list1.add( commentToCommentResponseDto( comment ) );
        }

        return list1;
    }

}
