package kr.co.erst.mobilelink_back.service;

import kr.co.erst.mobilelink_back.vo.AdminVo;
import kr.co.erst.mobilelink_back.vo.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    // Spring Security
    @Autowired
    AdminService adminService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AdminVo adminVo = adminService.findByUsername(username);
        UserDetails user = null;
        try {
            user = new CustomUserDetail(adminVo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
