package x12323.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class Indexcontroller {

    // 호출방법 : http://localhost:8080/
    @GetMapping("/first")           // action 메서드
    public String first() {

        // 비지니스 로직 처리

        return "first";         // view 리턴
        // 뷰리졸버 정의문에 의해
        // 머리말 + 꼬리말을 조합해서 뷰 랜더링
        // /WEB-INF/jsp/ + index + .jsp

    }

    // 호출방법 : http://localhost:8080/hello
    @RequestMapping(value = "/today", method = RequestMethod.GET)
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("today");    // 뷰 지정
        // /WEB-INF/jsp + hello + .jsp

        mv.addObject("msg", new Date());

        // 뷰에 넘길 객체를 modelandview 객체에 담음
        return mv;
    }
}
