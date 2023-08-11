package com.codestates.StackOverFlowClone.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {

    // 답변개수 제한
    @Transient
    private long replyLimitCount = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    @Column(length = 100, nullable = false)
    private String questionTitle;

    @Column(length = 20, nullable = false)
    private String questionWriter;

    @Column(length = 1000)
    private String questionContent;

    @CreatedDate
    @Column(name = "question_date_time")
    private LocalDateTime questionDateTime = LocalDateTime.now();

    public long getReplyLimitCount(){
        return replyLimitCount;
    }

    public void setReplyLimitCount(long replyLimitCount){
        this.replyLimitCount = replyLimitCount;
    }

}
