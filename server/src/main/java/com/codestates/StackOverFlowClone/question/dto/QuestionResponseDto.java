package com.codestates.StackOverFlowClone.question.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class QuestionResponseDto {

    private long questionId;

    private String questionTitle;

    private String questionWriter;

    private String questionContent;

    private LocalDateTime questionDttm;

    private long questionReplyLimitCount;

//    public void setMember(Member member){
//        this.memberId = member.getMemberId();
//    }
//
//    public void setCategory(Category category){
//        this.categoryId = category.getCategoryId();
//    }


}
