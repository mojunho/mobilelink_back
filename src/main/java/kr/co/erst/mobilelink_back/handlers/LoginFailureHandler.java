package kr.co.erst.mobilelink_back.handlers;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginFailureHandler implements AuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        System.out.println("========== FailureHandler에 들어왔다 ==========");

        String errorMessage = exception.getMessage();
        System.out.println("errorMsg: " + errorMessage);
        request.setAttribute("errorMsg", errorMessage);
        request.getRequestDispatcher("/login?error=true").forward(request, response);

        System.out.println("========== FailureHandler를 나갔다 ==========");
    }

}
