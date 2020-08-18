package kr.co.erst.mobilelink_back.controllers;

import kr.co.erst.mobilelink_back.service.AdminService;
import kr.co.erst.mobilelink_back.service.BoardService;
import kr.co.erst.mobilelink_back.vo.AdminVo;
import kr.co.erst.mobilelink_back.vo.BoardVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;

@Controller
@RequestMapping(value = "/board")
public class BoardController {

    @Resource
    BoardService boardService;

    @Resource
    AdminService adminService;

    // 게시글 등록 폼
    @RequestMapping(value = "/boardregister", method = RequestMethod.GET)
    public String boardRegisterGet() throws Exception {
        return "list/board/board-register";
    }

    // 게시글 목록
    @RequestMapping(value = "/boardlist", method = RequestMethod.GET)
    public String boardList() throws Exception {
        return "list/board/board-list";
    }

    // 게시글 상세보기
    @RequestMapping(value = "/boardview", method = RequestMethod.GET)
    public String boardView(int id, Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 쿠키 조회수 중복 방지
        Cookie[] cookies = request.getCookies();
        Cookie viewCookie = null;
        if (cookies != null && cookies.length > 0) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("cookie" + id)) {
                    viewCookie = cookies[i];
                }
            }
        }
        if (viewCookie == null) {
            Cookie newCookie = new Cookie("cookie" + id, "|" + id + "|");
            response.addCookie(newCookie);
            newCookie.setMaxAge(30 * 60);
            if (boardService.readCountClickToBoard(id)) {
                System.out.println("조회수 증가");
            } else {
                System.out.println("조회수 증가 실패");
            }
        } else {
            System.out.println("cookie 존재");
            String cookieName = viewCookie.getName();
            String cookieValue = viewCookie.getValue();
            System.out.println(cookieName + cookieValue);
            System.out.println("조회수 증가 실패");
        }
        //
        BoardVo board = boardService.selectOneBoard(id);
        if (board != null) {
            String oneTelecom = "";
            if (board.getTelecom() == 1) {
                oneTelecom = "SKT";
            } else if (board.getTelecom() == 2) {
                oneTelecom = "KT";
            } else if (board.getTelecom() == 3) {
                oneTelecom = "LGT";
            }
            AdminVo admin = adminService.nameById(board.getAdminId());
            model.addAttribute("boardId", board.getId());
            model.addAttribute("boardTelecom", oneTelecom);
            model.addAttribute("title", board.getTitle());
            model.addAttribute("content", board.getContent());
            model.addAttribute("regName", admin.getName());
            model.addAttribute("readCount", board.getReadCount());
            model.addAttribute("regDate", board.getRegDate());
            return "list/board/board-view";
        } else {
            return "/board/boardlist";
        }
    }

    // 게시글 수정 폼
    @RequestMapping(value = "/boardedit", method = RequestMethod.GET)
    public String boardEdit(int id, Model model, Principal principal) throws Exception {
        BoardVo board = boardService.selectOneBoard(id);
        if (board != null) {
            model.addAttribute("boardId", board.getId());
            model.addAttribute("boardTelecom", board.getTelecom());
            model.addAttribute("title", board.getTitle());
            model.addAttribute("content", board.getContent());
            return "list/board/board-edit";
        } else {
            System.out.println("해당 게시글 정보가 없습니다!");
            return "/board/boardview?id=" + id;
        }
    }

    // 게시글 삭제(status = 0), 비활성화
    @RequestMapping(value = "/boarddelete", method = RequestMethod.GET)
    public String boardDelete(int id) {
        if (boardService.deleteOneBoard(id)) {
            System.out.println("게시글 삭제 성공");
            return "redirect:/board/boardlist";
        } else {
            System.out.println("게시글 삭제 실패");
            return "/board/boardview?id=" + id;
        }
    }

}
