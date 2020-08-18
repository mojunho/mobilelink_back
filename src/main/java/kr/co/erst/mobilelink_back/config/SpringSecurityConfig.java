package kr.co.erst.mobilelink_back.config;

import kr.co.erst.mobilelink_back.handlers.CustomAuthenticationProvider;
import kr.co.erst.mobilelink_back.handlers.LoginFailureHandler;
import kr.co.erst.mobilelink_back.handlers.LoginSuccessHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private LoginSuccessHandler successHandler;
    @Autowired
    private LoginFailureHandler failureHandler;
    @Autowired
    private CustomAuthenticationProvider provider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
    } // static 디렉터리의 하위 파일 목록은 인증 무시(=항상통과), 여기선 webapp/resources 라서 없어도 된다.

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable();
        http
            .authorizeRequests()
//                .antMatchers("/login", "/errorpage").permitAll()
                .antMatchers("/member/**", "/board/**")
                .hasAuthority("ROLE_ADMIN")
//                hasRole("ADMIN")
//                hasAuthority("ROLE_ADMIN")
//                access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/**").permitAll()
                .anyRequest()
                .permitAll()
                .and()
            .formLogin()
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
//                .defaultSuccessUrl("/member/memberlist")
//                .failureUrl("/login?error=true")
                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .permitAll()
                .and()
            .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .invalidateHttpSession(true)
                .and()
            .csrf().disable()
                .headers().frameOptions().disable()
                .and();
//            .authenticationProvider(provider);
    }

}
