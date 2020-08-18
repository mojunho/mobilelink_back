package kr.co.erst.mobilelink_back.handlers;

import kr.co.erst.mobilelink_back.service.AdminService;
import kr.co.erst.mobilelink_back.vo.AdminVo;
import kr.co.erst.mobilelink_back.vo.CustomUserDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private AdminService adminService;

    @SuppressWarnings("unchecked")
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("========== Provider에 들어왔다 ==========");
        String username = (String)authentication.getPrincipal();
        String password = (String)authentication.getCredentials();

        HashMap<String, Object> map = new HashMap<>();
        map.put("username", username);
        map.put("password", password);
        AdminVo admin = adminService.findByAdmin(map);
        System.out.println("adminVo @@ " + admin);
        UserDetails user = new CustomUserDetail(admin);
        if (admin == null) {
            throw new UsernameNotFoundException("ID와 비밀번호를 다시 확인해 주세요.");
        }

        System.out.println(admin.getName() + "님 로그인 성공!");
        System.out.println("당신의 권한은 ? " + user.getAuthorities() + "입니다.");
        System.out.println("========== Provider를 나갔다 ==========");
        return new UsernamePasswordAuthenticationToken(username, password, user.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
