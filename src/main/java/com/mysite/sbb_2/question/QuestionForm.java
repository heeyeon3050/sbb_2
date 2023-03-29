package com.mysite.sbb_2.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//화면에서 전달되는 입력 값을 검증하기 위해서는 폼 클래스가 필요하다.
public class QuestionForm {
    @NotEmpty(message="제목은 필수항목입니다.") //Null 또는 빈 문자열("")을 허용하지 않는다.
    @Size(max=200) //문자 길이를 제한한다.
    private String subject;

    @NotEmpty(message="내용은 필수항목입니다.")
    private String content;
}