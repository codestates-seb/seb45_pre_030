package com.codestates.StackOverFlowClone.member.entity;

import com.codestates.StackOverFlowClone.comment.entity.Comment;
import com.codestates.StackOverFlowClone.question.entity.Question;
import com.codestates.StackOverFlowClone.reply.entity.Reply;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long memberId;

    @Column(nullable = false, updatable = false, unique = true)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

//    @OneToMany(mappedBy = "member" )
//    private List<Question> questions = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member" )
//    private List<Reply> replies = new ArrayList<>();
//
//    @OneToMany(mappedBy = "member" )
//    private List<Comment> comments = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();


}
