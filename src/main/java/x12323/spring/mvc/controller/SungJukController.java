package x12323.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import x12323.spring.mvc.service.SungJukV13Service;
import x12323.spring.mvc.vo.SungJukVO;

// URL
// ~/sungjuk (sungjuk.jsp)
// ~/sungjukok
// ~/sungjuklist
// ~/sungjukview


@Controller
public class SungJukController {

    @Autowired
    private SungJukV13Service sjsrv13;

    @GetMapping("/sungjuk")         // 성적입력폼
    public String sungjuk() {

        return "sungjuk";
    }

    // 성적입력처리
    // 성적입력폼에 입력한 내용들은 스프링 컨테이너에 의해
    // SungJukVO의 멤버변수에 자동으로 저장됨
    // 단, form의 각 변수명과 SungJukVO의 멤버변수명은 일치해야함
    //
    @PostMapping("/sungjukok")      // 성적입력처리
    public ModelAndView sungjukok(SungJukVO sjvo) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjukok");
        mv.addObject("result", sjsrv13.newSungJuk(sjvo));
        mv.addObject("sj",sjvo);

        return mv;
    }

    // 성적 데이터 조회
    // 학생번호, 이름, 국어, 영어, 수학, 등록일 형태 출력
    // ~/sungjuklist -> sjsrv13 -> sjdao12 -> db
    //      view        service     dao
    @GetMapping("/sungjuklist")    // 성적조회
    public ModelAndView sungjuklist() {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("sungjuklist");
        mv.addObject("sjlist",sjsrv13.readSungJuk());
        return mv;
    }

    // sungjuklist.jsp에서
    // 학생이름을 클릭하면 학생번호sjno를 전송
    @GetMapping("/sungjukview")
    public ModelAndView sungjukview(String sjno) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("sungjukview");
        mv.addObject("sj",sjsrv13.readOneSungJuk(sjno));
        return mv;
    }

    @GetMapping("/sungjukdel")
    public String sungjukdel(String sjno){

        System.out.println(sjsrv13.removeSungJuk(sjno));

        // 성적데이터를 삭제하고 난뒤 /sungjuklist로 바로 이동
       return "redirect:/sungjuklist";
    }

    @GetMapping("/sungjukupd")
    public ModelAndView sungjukupd(String sjno) {
        ModelAndView mv = new ModelAndView();

        mv.setViewName("sungjukupd");
        mv.addObject("sj",sjsrv13.readOneSungJuk(sjno));

        return mv;
    }

    // 수정할 성적데이터를 전송 받아서
    // sungjuk테이블에 적용하고 sungjuklist로 redirect함
    @GetMapping("/sungjukupdok")
    public String sungjukupdok(SungJukVO sj) {

        System.out.println(sjsrv13.modifySungJuk(sj));

        return "redirect:/sungjuklist";
    }
}
