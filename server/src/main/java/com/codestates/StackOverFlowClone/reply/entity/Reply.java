package com.codestates.StackOverFlowClone.reply.entity;

import com.codestates.StackOverFlowClone.question.entity.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long replyId;
    /*
    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;
     */
    @Column(nullable = false)
    private long questionId;

    @Column(nullable = false)
    private long memberId;

    @Lob
    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(name = "reply_dttm", updatable = false)
    private LocalDateTime replyDttm;
}
