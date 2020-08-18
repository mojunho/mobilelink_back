package kr.co.erst.mobilelink_back.mapper;

import kr.co.erst.mobilelink_back.vo.AdminVo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface AdminMapper {

    AdminVo findByUsername(String username);

    AdminVo findByAdmin(HashMap<String, Object> map);

    AdminVo nameById(int id);

    AdminVo findIdByLogin(String username);

}
