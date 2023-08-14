package com.codestates.StackOverFlowClone.question.entity;

import com.codestates.StackOverFlowClone.reply.entity.Reply;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long questionId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 20, nullable = false)
    private long memberId;

    @Column(length = 1000)
    private String content;

    @Column
    private Long viewCount = 0L;

    @OneToMany(mappedBy = "question")
    private List<Reply> replies = new ArrayList<>();

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
    // 답변개수 제한
    @Transient
    private long replyLimitCount = 5;



}
