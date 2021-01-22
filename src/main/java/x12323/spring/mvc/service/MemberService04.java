package x12323.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import x12323.spring.mvc.dao.MemberDAO03;
import x12323.spring.mvc.vo.MemberVO;

import java.util.List;


@Service("msrv04")
public class MemberService04 implements MemberService {

    @Autowired
    private MemberDAO03 mdao03;

    public String newMember(MemberVO mvo) {
        String result = "회원데이터 처리중..?";
        int cnt = mdao03.insertMember(mvo);
        if(cnt > 0) result = "회원데이터 저장완료";

        return null;
    }

    // 회원 정보 수정 (이름, 등급, 포인트)
    public String modifyMember(MemberVO mvo) {
        String result = "Memberinfo modifying...?!?";
        int cnt = mdao03.updateMember(mvo);
        if (cnt > 0) result = "Memberinfo modifying completed!!";
        return result;
    }

    // 회원 정보 삭제 (이름)
    public String removeMember(String name) {
        String result = "회원정보 삭제처리중...?!?";
        return null;
    }

    public List<MemberVO> readMember() {

        return mdao03.selectMember();
    }

    public MemberVO readOneMember(String userid) {

        return mdao03.selectOneMember(userid);
    }
}
