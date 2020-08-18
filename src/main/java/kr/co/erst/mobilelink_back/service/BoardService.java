package kr.co.erst.mobilelink_back.service;

import kr.co.erst.mobilelink_back.vo.BoardVo;

import java.util.List;
import java.util.Map;

public interface BoardService {

    List<BoardVo> searchBoard(Map<String, Object> map);

    int countSearchBoard(Map<String, Object> map);

    BoardVo selectOneBoard(int id);

    boolean insertNewBoard(BoardVo boardVo);

    boolean readCountClickToBoard(int id);

    boolean updateOneBoard(Map<String, Object> map);

    boolean deleteOneBoard(int id);

    boolean realDeleteOneBoard(int id);

}
