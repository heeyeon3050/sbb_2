package com.mysite.sbb_2.question;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.mysite.sbb_2.answer.Answer;
import com.mysite.sbb_2.user.SiteUser;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

@Getter
@Setter
@Entity
public class Question {
    @Id //기본키
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO_INCREMENT
    private Integer id;

    @Column(length = 200) //컬럼 길이
    private String subject;

    @Column(columnDefinition = "TEXT") //글자수를 제한할 수 없을 때 사용
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE) //답변 여러개에 대해 질문은 하나
    private List<Answer> answerList = new ArrayList<>();

    public void addAnswer(Answer a) {
        a.setQuestion(this); //this는 question 객체
        answerList.add(a);
    }

    @ManyToOne
    private SiteUser author;

    private LocalDateTime modifyDate;

    @ManyToMany
    Set<SiteUser> voter;

    //@Column(nullable = false)
    //@Column(columnDefinition = "long default 0")
    @NotNull
    @ColumnDefault("0")
    private long views;
}