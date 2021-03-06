package x12323.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import x12323.spring.mvc.service.MemberService;
import x12323.spring.mvc.vo.MemberVO;

@Controller
public class MemberController {

    @Autowired
    private MemberService msrv04;

    @GetMapping("/member")
    public String member() {    // 회원정보입력폼
        return "member";
    }

    @PostMapping("/memberok")   // 회원가입처리
    public ModelAndView memberok(MemberVO mvo) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberok");
        mv.addObject("result", msrv04.newMember(mvo));
        mv.addObject("mvo", mvo);
        return mv;
    }

    @GetMapping("/memberlist")
    public ModelAndView memberlist() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberlist");   // WEB-INF/jsp/memberlist.jsp
        mv.addObject("mvos",msrv04.readMember());


        return mv;
    }

    @GetMapping("/memberview")
    public ModelAndView memberview(String userid) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberview");
        mv.addObject("mvo",msrv04.readOneMember(userid));

        return mv;
    }

    @GetMapping("/memberdel")
    public String memberdel(String name){

        System.out.println(msrv04.removeMember(name));

        // 성적데이터를 삭제하고 난뒤 /sungjuklist로 바로 이동
        return "redirect:/memberlist";
    }

    @GetMapping("/memberupd")
    public ModelAndView memberupd(String userid) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("memberupd");
        mv.addObject("mvo",msrv04.readOneMember(userid));

        return mv;
    }

    @GetMapping("/memberupdok")
    public String memberupdok(MemberVO mvo) {
        System.out.println(msrv04.modifyMember(mvo));

        return "redirect:/memberlist";
    }
}
