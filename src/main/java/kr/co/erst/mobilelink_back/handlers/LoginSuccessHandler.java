package kr.co.erst.mobilelink_back.handlers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        System.out.println("========== SuccessHandler에 들어왔다 ==========");

        List<GrantedAuthority> authorities = (List<GrantedAuthority>)authentication.getAuthorities();
        String strAuth = authorities.get(0).getAuthority();
        if (strAuth.equals("ROLE_ADMIN")) {
            System.out.println("로그인 성공! " + authorities);
            System.out.println("========== SuccessHandler를 나갔다 ==========");
            response.sendRedirect(request.getContextPath() + "/member/memberlist");
        } else {
            System.out.println("로그인 실패");
            System.out.println("========== SuccessHandler를 나갔다 ==========");
            response.sendRedirect(request.getContextPath() + "/login");
        }
   }

}
