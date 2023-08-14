package com.codestates.StackOverFlowClone.question.mapper;


import com.codestates.StackOverFlowClone.question.dto.QuestionDto;
import com.codestates.StackOverFlowClone.question.dto.OnlyQuestionResponseDto;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.reply.dto.ReplyResponseDto;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface QuestionMapper {

    Question questionPostDtoToQuestion(QuestionDto.Post questionPostDto);

    Question questionPatchDtoToQuestion(QuestionDto.Patch questionPatchDto);

    default QuestionDto.Response questionToQuestionResponseDto(Question question) {
        OnlyQuestionResponseDto onlyQuestionResponseDto =
                OnlyQuestionResponseDto.builder()
                        .questionId(question.getQuestionId())
                        .memberId(question.getMemberId())
                        .title(question.getTitle())
                        .content(question.getContent())
                        .createdAt(question.getCreatedAt())
                        .viewCount(question.getViewCount())
                        .build();
        List<ReplyResponseDto> replyResponseDtos = new ArrayList<>();
        if(question.getReplies() != null) {
            for(Reply reply : question.getReplies()) {
                ReplyResponseDto replyResponseDto =
                        ReplyResponseDto.builder()
                                .replyId(reply.getReplyId())
                                .questionId(reply.getQuestion().getQuestionId())
                                .memberId(reply.getMemberId())
                                .content(reply.getContent())
                                .createdAt(reply.getCreatedAt())
                                .build();
                replyResponseDtos.add(replyResponseDto);
            }
        }
        return new QuestionDto.Response(onlyQuestionResponseDto, replyResponseDtos);
    }

    OnlyQuestionResponseDto questionToOnlyQuestionResponseDto(Question question);

    List<OnlyQuestionResponseDto> questionsToOnlyQuestionResponseDtos(List<Question> questions);

}


//public interface QuestionMapper {
//
//    default Content contentPostDtoToContent(ContentPostDto contentPostDto){
//        Content content = new Content();
//
//        content.setTitle(contentPostDto.getTitle());
//        content.setContent(contentPostDto.getContent());
//        content.setAttachFile(contentPostDto.getAttachFile());
//        Member member = new Member();
//        member.setMemberId(contentPostDto.getMemberId());
//        member.setName(contentPostDto.getMemberName());
//        content.setMember(member);
//        Category category = new Category();
//        category.setCategoryId(contentPostDto.getCategoryId());
//        category.setCategoryName(contentPostDto.getCategoryName());
//        content.setCategory(category);
//        // 만약 content.createdAt 빼서 안나올 경우... 수동으로 넣어.
////        content.setCreatedAt(LocalDateTime.now());
////        content.setModifiedAt(LocalDateTime.now());
//
//        return content;
//
//    }
//
//    default Content contentPatchDtoToContent(ContentPatchDto contentPatchDto){
//
//        Content content = new Content();
//
//        content.setNoticeId(contentPatchDto.getNoticeId());
//        content.setTitle(contentPatchDto.getTitle());
//        content.setContent(contentPatchDto.getContent());
//        content.setAttachFile(contentPatchDto.getAttachFile());
//        Category category = new Category();
//        category.setCategoryId(contentPatchDto.getCategoryId());
//        category.setCategoryName(contentPatchDto.getCategoryName());
//        content.setCategory(category);
//        Member member = new Member();
//        member.setMemberId(contentPatchDto.getMemberId());
//        member.setName(contentPatchDto.getMemberName());
//        content.setMember(member);
//        // 만약 content.createdAt 빼서 안나올 경우... 수동으로 넣어.
////        content.setCreatedAt(LocalDateTime.now());
////        content.setModifiedAt(LocalDateTime.now());
//
//        return content;
//    }
//
//    default ContentResponseDto contentToContentResponseDto(Content content){
//        ContentResponseDto contentResponseDto = new ContentResponseDto();
//
//        contentResponseDto.setNoticeId(content.getNoticeId());
//        contentResponseDto.setTitle(content.getTitle());
//        contentResponseDto.setContent(content.getContent());
//        contentResponseDto.setAttachFile(content.getAttachFile());
//        contentResponseDto.setCategoryId(content.getCategory().getCategoryId());
//        contentResponseDto.setMemberId(content.getMember().getMemberId());
//        contentResponseDto.setCategoryName(content.getCategory().getCategoryName());
//        contentResponseDto.setMemberName(content.getMember().getName());
//        contentResponseDto.setCreatedAt(content.getCreatedAt());
//        contentResponseDto.setModifiedAt(content.getModifiedAt());
//
//        return contentResponseDto;
//    }
//
//}
