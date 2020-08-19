package kr.co.erst.mobilelink_back.controllers;

import kr.co.erst.mobilelink_back.service.AdminService;
import kr.co.erst.mobilelink_back.service.BoardService;
import kr.co.erst.mobilelink_back.vo.AdminVo;
import kr.co.erst.mobilelink_back.vo.BoardVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest")
public class BoardRestController {

    @Resource
    BoardService boardService;

    @Resource
    AdminService adminService;

    public static final int LIMIT = 10;

    // 게시글 목록
    @RequestMapping(value = "/boardlistrest", method = RequestMethod.POST)
    public Map boardListRest(@RequestBody Map<String, Object> searchInfo) throws Exception {
        int telecomNum;
        if (searchInfo.get("telecom").equals("")) {
            telecomNum = 0;
        } else {
            telecomNum = Integer.parseInt((String)searchInfo.get("telecom"));
        }
        String search = (String)searchInfo.get("search");
        String keyword = (String)searchInfo.get("keyword");
        int offset = ((int)searchInfo.get("pageNumber") - 1) * LIMIT;
        System.out.println("@@@ telecom: " + telecomNum);
        System.out.println("@@@ search: " + searchInfo.get("search"));
        System.out.println("@@@ keyword: " + searchInfo.get("keyword"));
        System.out.println("@@@ pageNumber: " + searchInfo.get("pageNumber"));
        System.out.println("==========+==========+==========");
        HashMap res = new HashMap();
        try {
            Map<String, Object> boardCntInfo = new HashMap<>();
            boardCntInfo.put("telecom", telecomNum);
            boardCntInfo.put("search", search);
            boardCntInfo.put("keyword", keyword);
            int boardListCnt = boardService.countSearchBoard(boardCntInfo);
            Map<String, Object> boardInfo = new HashMap<>();
            boardInfo.put("telecom", telecomNum);
            boardInfo.put("search", search);
            boardInfo.put("keyword", keyword);
            boardInfo.put("offset", offset);
            boardInfo.put("limit", LIMIT);
            List<BoardVo> boardList = boardService.searchBoard(boardInfo);
            if (boardList != null) {
                List<Map<String, Object>> pList = new ArrayList<>();
                for (int i = 0; i < boardList.size(); i++) {
                    String telecom = "";
                    if (boardList.get(i).getTelecom() == 1) {
                        telecom = "SKT";
                    } else if (boardList.get(i).getTelecom() == 2) {
                        telecom = "KT";
                    } else if (boardList.get(i).getTelecom() == 3) {
                        telecom = "LGT";
                    }
                    SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
                    String regDate = fmt.format(boardList.get(i).getRegDate());
                    AdminVo adminVo = adminService.nameById(boardList.get(i).getAdminId());
                    Map<String, Object> pMap = new HashMap<>();
                    pMap.put("id", boardList.get(i).getId());
                    pMap.put("title", boardList.get(i).getTitle());
                    pMap.put("telecom", telecom);
                    pMap.put("content", boardList.get(i).getContent());
                    pMap.put("readCount", boardList.get(i).getReadCount());
                    pMap.put("regName", adminVo.getName());
                    pMap.put("regDate", regDate);
                    pList.add(pMap);
                }
                int maxPage = boardListCnt / LIMIT + (boardListCnt % LIMIT == 0 ? 0 : 1);
                res.put("boardList", pList);
                res.put("totalData", boardListCnt);
                res.put("maxPage", maxPage);
                res.put("msg", "통신 성공 및 데이터 전송");
            } else {
                res.put("notFoundMsg", "게시글 목록이 없습니다.");
                res.put("msg", "통신 성공 및 데이터 전송 실패");
            }
        } catch (Exception e) {
            res.put("msg", "통신 에러");
            e.printStackTrace();
        }
        return res;
    }

    // 게시글 등록
    @RequestMapping(value = "/boardregrest", method = RequestMethod.POST)
    public Map boardRegRest(@RequestBody Map<String, Object> regInfo, Principal principal) throws Exception {
        int telecomNum;
        if (regInfo.get("telecom").equals("")) {
            telecomNum = 0;
        } else {
            telecomNum = Integer.parseInt((String)regInfo.get("telecom"));
        }
        String title = (String)regInfo.get("title");
        String content = (String)regInfo.get("content");
        String username = principal.getName();
        AdminVo admin = adminService.findIdByLogin(username);
        System.out.println("@@@ telecom: " + telecomNum);
        System.out.println("@@@ title: " + title);
        System.out.println("@@@ content: " + content);
        System.out.println("@@@ regname: " + admin.getName());
        System.out.println("==========+==========+==========");
        Map res = new HashMap();
        try {
            BoardVo board = new BoardVo(title, content, telecomNum, admin.getId());
            if (boardService.insertNewBoard(board)) {
                System.out.println("게시글 등록 성공!");
                res.put("msg", "통신 성공 및 게시글 등록 성공");
            } else {
                System.out.println("게시글 등록 실패!");
                res.put("msg", "통신 성공 및 게시글 등록 실패");
            }
        } catch (Exception e) {
            res.put("msg", "통신 에러");
            e.printStackTrace();
        }
        return res;
    }

    // 게시글 수정
    @RequestMapping(value = "/boardeditrest", method = RequestMethod.POST)
    public Map boardEditRest(@RequestBody Map<String, Object> editInfo, Principal principal) throws Exception {
        int telecomNum;
        if (editInfo.get("telecom").equals("")) {
            telecomNum = 0;
        } else {
            telecomNum = Integer.parseInt((String)editInfo.get("telecom"));
        }
        String title = (String)editInfo.get("title");
        String content = (String)editInfo.get("content");
        String username = principal.getName();
        int id = Integer.parseInt((String)editInfo.get("id"));
        AdminVo admin = adminService.findIdByLogin(username);
        System.out.println("@@@ telecom: " + telecomNum);
        System.out.println("@@@ title: " + title);
        System.out.println("@@@ content: " + content);
        System.out.println("@@@ regname: " + admin.getName());
        System.out.println("==========+==========+==========");
        Map res = new HashMap();
        try {
            Map<String, Object> boardEditInfo = new HashMap<>();
            boardEditInfo.put("title", title);
            boardEditInfo.put("content", content);
            boardEditInfo.put("telecom", telecomNum);
            boardEditInfo.put("id", id);
            boardEditInfo.put("adminId", admin.getId());
            if (boardService.updateOneBoard(boardEditInfo)) {
                System.out.println("게시글 수정 성공!");
                res.put("msg", "통신 성공 및 게시글 수정 성공");
            } else {
                System.out.println("게시글 수정 실패!");
                res.put("msg", "통신 성공 및 게시글 수정 실패");
            }
        } catch (Exception e) {
            res.put("msg", "통신 에러");
            e.printStackTrace();
        }
        return res;
    }

}
