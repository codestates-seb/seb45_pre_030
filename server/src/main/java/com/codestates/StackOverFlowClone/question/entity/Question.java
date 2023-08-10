package com.codestates.StackOverFlowClone.question.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

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
    private String questionTitle;

    @Column(length = 20, nullable = false)
    private String questionWriter;

    @Column(length = 1000)
    private String questionContent;

    @CreatedDate
    @Column(name = "question_dttm")
    private LocalDateTime questionDttm = LocalDateTime.now();

    @Column
    private long questionReplyLimitCount;

//    @ManyToOne
//    @JoinColumn(name = "CATEGORY_ID")
//    private Category category;
//
//    @ManyToOne
//    @JoinColumn(name = "MEMBER_ID")
//    private Member member;


//    public Category getCategory() {
//        return category;
//    }
//
//    public void setCategory(Category category) {
//        this.category = category;
//    }
//
//    public Member getMember() {
//        return member;
//    }
//
//    public void setMember(Member member) {
//        this.member = member;
//    }
}
