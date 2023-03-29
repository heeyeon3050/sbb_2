package com.mysite.sbb_2.question;

import com.mysite.sbb_2.answer.AnswerForm;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor //questionRepository 속성을 포함하는 생성자를 생성
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    @GetMapping("/create")
    public String questionCreate(QuestionForm questionForm) {
        return "question_form";
    }

    @PostMapping("/create")
    //@Valid 를 붙여야 검증 기능이 동작. bindingResult는 @Valid로 인해 검증이 수행된 결과를 의미하는 객체
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        questionService.create(questionForm.getSubject(), questionForm.getContent()); //매개변수를 subject, content 대신 QuestionForm 객체로 변경
        return "redirect:/question/list"; // 질문 저장후 질문목록으로 이동
    }
}