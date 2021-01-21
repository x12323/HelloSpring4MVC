package x12323.spring.mvc.dao;

import x12323.spring.mvc.vo.MemberVO;

import java.util.List;

public interface MemberDAO {
    int insertMember(MemberVO mvo);
    int updateMember(MemberVO mvo);
    int deleteMember(String name);

    List<MemberVO> selectMember();
    MemberVO selectOneMember(String userid);

}
