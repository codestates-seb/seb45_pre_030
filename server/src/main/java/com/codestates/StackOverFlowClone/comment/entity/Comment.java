package com.codestates.StackOverFlowClone.comment.entity;

import com.codestates.StackOverFlowClone.reply.entity.Reply;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long commentId;

//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;

    @Column(nullable = false, updatable = false)
    private long memberId;

    @ManyToOne
    @JoinColumn(name = "REPLY_ID")
    private Reply reply;

    @Column(length = 1000)
    private String content;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

//    @Column(nullable = false, updatable = false)
//    long depth;
//    @Column(nullable = true, updatable = false)
//    long parentCommentId;
}
