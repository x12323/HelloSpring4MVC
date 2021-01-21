package x12323.spring.mvc.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import x12323.spring.mvc.vo.MemberVO;

import java.util.List;

@Repository("mdao03")
public class MemberDAO03 implements MemberDAO {

    @Autowired
    private SqlSession sqlSession;
    // MemberDAO 에서 사용할 JdbcTemplate 객체를
    // DI 받기 위해 @Autowired 로 선언

    public int insertMember(MemberVO mvo) {

        return sqlSession.insert("member.insertMember",mvo);
    }

    public int updateMember(MemberVO mvo) {
        return sqlSession.insert("member.updateMember",mvo);
    }


    public int deleteMember(String name) {
        return sqlSession.delete("member.deleteMember",name);
    }

    public List<MemberVO> selectMember() {
        return sqlSession.selectList("member.selectList");
    }

    public MemberVO selectOneMember(String userid) {
        return sqlSession.selectOne("member.selectOne",userid);
    }
}
