package x12323.spring.mvc.dao;

import x12323.spring.mvc.vo.SungJukVO;

import java.util.List;

public interface SungJukV12DAO {
    String insertSungJuk(SungJukVO sj);
    List<SungJukVO> selectSungJuk();
    SungJukVO selectOneSungJuk(String sjno);
    String updateSungJuk(SungJukVO sj);
    String deleteSungJuk(int sjno);
}
