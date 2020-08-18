package kr.co.erst.mobilelink_back.controllers;

import kr.co.erst.mobilelink_back.service.MemberService;
import kr.co.erst.mobilelink_back.vo.MemberVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/member")
public class MemberController {

    @Resource
    MemberService memberService;

    public static final int LIMIT = 10;

    // 회원 등록 폼
    @RequestMapping(value = "/memberregister", method = RequestMethod.GET)
    public String memberRegisterGet(Model model) throws Exception {
        model.addAttribute("memberVo", new MemberVo());
        return "list/member/member-register";
    }

    // 회원 등록 프로세스
    @RequestMapping(value = "/memberregister", method = RequestMethod.POST)
    public String memberRegister(@Valid @ModelAttribute("memberVo") MemberVo memberVo, BindingResult bindingResult,
                                 String telecom, String name, String login, String password, String phonenumber, Model model) throws Exception {
        int telecomToString = Integer.parseInt(telecom);
        MemberVo member = new MemberVo(name, login, password, phonenumber, telecomToString);
        if (bindingResult.hasErrors()) {
            for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {
                System.out.println(bindingResult.getAllErrors().get(i).getDefaultMessage());
            }
            model.addAttribute("retelecom", telecom);
            return "list/member/member-register";
        } else if (memberService.insertNewMember(member)) {
            System.out.println("통신사: " + telecom);
            System.out.println("이름: " + name);
            System.out.println("아이디: " + login);
            System.out.println("비밀번호: " + password);
            System.out.println("전화번호: " + phonenumber);
            System.out.println("회원등록 성공!");
            return "redirect:/member/memberlist";
        } else {
            return "list/member/member-register";
        }
    }
    // 회원 목록
    @RequestMapping(value = "/memberlist", method = RequestMethod.GET)
    public String memberList(Model model, @RequestParam(value = "pn", required = false, defaultValue = "1") int pgNumber,
                             String keyword, String telecom, String search) throws Exception {
        int offset = (pgNumber - 1) * LIMIT;
        //------ 페이징
        Map<String, Object> memberCntInfo = new HashMap<>();
        memberCntInfo.put("telecom", telecom);
        memberCntInfo.put("search", search);
        memberCntInfo.put("keyword", keyword);
        int memberListCnt = memberService.countSearchMember(memberCntInfo);
        int maxPg = memberListCnt / LIMIT + (memberListCnt % LIMIT == 0 ? 0 : 1);
        if (pgNumber > maxPg || pgNumber <= 0) {
            System.out.println("잘못된 페이지 번호: " + pgNumber);
            return "redirect:/member/memberlist?pn=1";
        }
        //------ 페이징
        Map<String, Object> memberInfo = new HashMap<String, Object>();
        memberInfo.put("telecom", telecom);
        memberInfo.put("search", search);
        memberInfo.put("keyword", keyword);
        memberInfo.put("offset", offset);
        memberInfo.put("limit", LIMIT);
        List<MemberVo> memberList = memberService.searchMember(memberInfo);
        if (memberList != null) {
            List<Map<String, Object>> pList = new ArrayList<>();
            for (int i = 0; i < memberList.size(); i++) {
                Map<String, Object> pMap = new HashMap<>();
                pMap.put("id", memberList.get(i).getId());
                pMap.put("name", memberList.get(i).getName());
                pMap.put("login", memberList.get(i).getLogin());
                pMap.put("telecom", memberList.get(i).getTelecom());
                pMap.put("phnum", memberList.get(i).getPhonenumber());
                pMap.put("createddate", memberList.get(i).getCreatedDate());
                pList.add(pMap);
            }
            model.addAttribute("maxPg", maxPg);
            model.addAttribute("pn", pgNumber);
            model.addAttribute("memberList", pList);
            model.addAttribute("telecomOne", telecom);
            model.addAttribute("searchOne", search);
            model.addAttribute("keywordOne", keyword);
            return "list/member/member-list";
        } else {
            return "redirect:/member/member-list";
        }
    }
    // 회원 상세보기
    @RequestMapping(value = "/memberview", method = RequestMethod.GET)
    public String memberView(int id, Model model, HttpSession session) throws Exception {
        MemberVo member = memberService.selectOneMember(id);
        if (member != null) {
            String oneTelecom = "";
            if (member.getTelecom() == 1) {
                oneTelecom = "SKT";
            } else if (member.getTelecom() == 2) {
                oneTelecom = "KT";
            } else if (member.getTelecom() == 3) {
                oneTelecom = "LGT";
            }
            model.addAttribute("memberTelecom", oneTelecom);
            model.addAttribute("memberLogin", member.getLogin());
            model.addAttribute("memberName", member.getName());
            model.addAttribute("memberPhNum", member.getPhonenumber());
            model.addAttribute("memberPassword", member.getPassword());
            session.setAttribute("member", member);
            session.setAttribute("memberId", member.getId());
            return "list/member/member-view";
        } else {
            return "/member/memberlist";
        }
    }

    // 회원 수정 폼
    @RequestMapping(value = "/memberedit", method = RequestMethod.GET)
    public String memberEditGet(HttpSession session, Model model) throws Exception {
        MemberVo member = (MemberVo)session.getAttribute("member");
        if (member != null) {
            model.addAttribute("memberName", member.getName());
            model.addAttribute("memberLogin", member.getLogin());
            model.addAttribute("memberTelecom", member.getTelecom());
            model.addAttribute("memberVo", member);
            return "list/member/member-edit";
        } else {
            return "/member/memberview";
        }
    }

    // 회원 수정 프로세스
    @RequestMapping(value = "/memberedit", method = RequestMethod.POST)
    public String memberEdit(@Valid @ModelAttribute("memberVo") MemberVo memberVo, BindingResult bindingResult, Model model,
                             String telecom, String name, String login, String password, String phonenumber, HttpSession session) throws Exception {
        Map<String, Object> memberEditInfo = new HashMap<>();
        memberEditInfo.put("password", password);
        memberEditInfo.put("phonenumber", phonenumber);
        memberEditInfo.put("telecom", telecom);
        memberEditInfo.put("login", login);
        memberEditInfo.put("name", name);
        if (bindingResult.hasErrors()) {
            for (int i = 0; i < bindingResult.getAllErrors().size(); i++) {
                System.out.println(bindingResult.getAllErrors().get(i).getDefaultMessage());
            }
            model.addAttribute("memberTelecom", telecom);
            return "list/member/member-edit";
        } else if (memberService.updateOneMember(memberEditInfo)) {
            System.out.println("통신사: " + telecom);
            System.out.println("이름: " + name);
            System.out.println("아이디: " + login);
            System.out.println("비밀번호: " + password);
            System.out.println("전화번호: " + phonenumber);
            System.out.println("회원수정 성공!");
            int id = (int)session.getAttribute("memberId");
            return "redirect:/member/memberview?id=" + id;
        } else {
            return "/member/memberview?id=" + memberVo.getId();
        }
    }

    // 회원 정보 삭제(status = 0), 비활성화
    @RequestMapping(value = "/memberdelete", method = RequestMethod.POST)
    public String memberDelete(Model model, HttpSession session, String login, String password, String name) throws Exception {
        int id = (int)session.getAttribute("memberId");
        Map<String, Object> memberDeleteInfo = new HashMap<>();
        memberDeleteInfo.put("id", id);
        memberDeleteInfo.put("login", login);
        memberDeleteInfo.put("password", password);
        if (memberService.deleteOneMember(memberDeleteInfo)) {
            System.out.println("회원번호: " + id);
            System.out.println("이름: " + name);
            System.out.println("아이디: " + login);
            System.out.println("비밀번호: " + password);
            System.out.println(name + "님을 삭제했습니다.");
            return "redirect:/member/memberlist";
        } else {
            System.out.println(name + "님의 회원정보 삭제 실패!");
            return "/member/memberview?id=" + id;
        }
    }
}
