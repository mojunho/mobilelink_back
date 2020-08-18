package kr.co.erst.mobilelink_back.service;

import kr.co.erst.mobilelink_back.vo.AdminVo;

import java.util.HashMap;

public interface AdminService {

    AdminVo findByUsername(String username);

    AdminVo findByAdmin(HashMap<String, Object> map);

    AdminVo nameById(int id);

    AdminVo findIdByLogin(String username);

}
