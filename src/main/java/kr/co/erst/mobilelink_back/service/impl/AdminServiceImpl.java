package kr.co.erst.mobilelink_back.service.impl;

import kr.co.erst.mobilelink_back.mapper.AdminMapper;
import kr.co.erst.mobilelink_back.service.AdminService;
import kr.co.erst.mobilelink_back.vo.AdminVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public AdminVo findByUsername(String username) {
        AdminVo adminVo = adminMapper.findByUsername(username);
        return adminVo;
    }

    @Override
    public AdminVo findByAdmin(HashMap<String, Object> map) {
        AdminVo adminVo = adminMapper.findByAdmin(map);
        return adminVo;
    }

    @Override
    public AdminVo nameById(int id) {
        AdminVo adminVo = adminMapper.nameById(id);
        return adminVo;
    }

    @Override
    public AdminVo findIdByLogin(String username) {
        AdminVo adminVo = adminMapper.findIdByLogin(username);
        return adminVo;
    }

}
