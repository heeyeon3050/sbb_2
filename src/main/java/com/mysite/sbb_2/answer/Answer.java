package com.mysite.sbb_2.answer;

import java.time.LocalDateTime;

import com.mysite.sbb_2.question.Question;
import com.mysite.sbb_2.user.SiteUser;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @ManyToOne //질문 하나에 답변 여러개
    private Question question;

    @ManyToOne
    private SiteUser author;
}
