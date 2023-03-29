package com.mysite.sbb_2.answer;

import com.mysite.sbb_2.question.Question;
import com.mysite.sbb_2.question.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {

    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) { //content는 템플릿의 속성명과 맞춰야해서 content로 해야 함
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);
    }
}
