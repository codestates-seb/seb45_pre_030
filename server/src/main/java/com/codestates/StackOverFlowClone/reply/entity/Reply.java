package com.codestates.StackOverFlowClone.reply.entity;

import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.question.entity.Question;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Reply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long replyId;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    private Question question;

    @Column(nullable = false, updatable = false)
    private long memberId;

    @Lob
    @Column(nullable = false)
    private String content;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "reply")
    private List<Comment> comments = new ArrayList<>();

    public Reply(Question question, long memberId, String content) {
        this.question = question;
        this.memberId = memberId;
        this.content = content;
    }
}


