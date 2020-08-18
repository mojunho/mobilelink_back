package kr.co.erst.mobilelink_back.service.impl;

import kr.co.erst.mobilelink_back.mapper.BoardMapper;
import kr.co.erst.mobilelink_back.service.BoardService;
import kr.co.erst.mobilelink_back.vo.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("BoardService")
public class BoardServiceImpl implements BoardService {

    @Autowired
    private BoardMapper boardMapper;

    @Override
    public List<BoardVo> searchBoard(Map<String, Object> map) {
        List<BoardVo> boardList = boardMapper.searchBoard(map);
        return boardList;
    }

    @Override
    public int countSearchBoard(Map<String, Object> map) {
        int boardCnt = boardMapper.countSearchBoard(map);
        return boardCnt;
    }

    @Override
    public BoardVo selectOneBoard(int id) {
        BoardVo board = boardMapper.selectOneBoard(id);
        return board;
    }

    @Override
    public boolean insertNewBoard(BoardVo boardVo) {
        return boardMapper.insertNewBoard(boardVo);
    }

    @Override
    public boolean readCountClickToBoard(int id) {
        return boardMapper.readCountClickToBoard(id);
    }

    @Override
    public boolean updateOneBoard(Map<String, Object> map) {
        return boardMapper.updateOneBoard(map);
    }

    @Override
    public boolean deleteOneBoard(int id) {
        return boardMapper.deleteOneBoard(id);
    }

    @Override
    public boolean realDeleteOneBoard(int id) {
        return boardMapper.realDeleteOneBoard(id);
    }

}
