package kr.co.erst.mobilelink_back.mapper;

import kr.co.erst.mobilelink_back.vo.BoardVo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BoardMapper {

    List<BoardVo> searchBoard(Map<String, Object> map);

    int countSearchBoard(Map<String, Object> map);

    BoardVo selectOneBoard(int id);

    boolean insertNewBoard(BoardVo boardVo);

    boolean readCountClickToBoard(int id);

    boolean updateOneBoard(Map<String, Object> map);

    boolean deleteOneBoard(int id);

    boolean realDeleteOneBoard(int id);

}
