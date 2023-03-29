package com.mysite.sbb_2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

    //서버에 요청이 발생하면 스프링부트는 요청 페이지와 매핑되는 메서드를 컨트롤러를 대상으로 찾는다.
    //스프링부트는 http://localhost:8080/sbb 요청이 발생하면 /sbb URL과 매핑되는 index 메서드를 MainController에서 찾아 실행한다.
    @GetMapping("/sbb") //URL 매핑
    @ResponseBody //URL 요청에 대한 응답으로 문자열을 리턴하라는 의미 //@ResponseBody를 생략하면, "index"라는 파일을 찾게 됨
    public String index() {
        System.out.println("index");
        return "index";
    }

    //ROOT URL
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
