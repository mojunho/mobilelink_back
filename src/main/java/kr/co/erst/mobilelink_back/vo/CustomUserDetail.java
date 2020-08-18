package kr.co.erst.mobilelink_back.vo;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetail implements UserDetails {
    // Spring Security AdminVo에 다 넣어도 될거같다.
    private AdminVo adminVo;

    public CustomUserDetail(AdminVo adminVo) {
        this.adminVo = adminVo;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(adminVo.getRole()));
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.adminVo.getPassword();
    }

    @Override
    public String getUsername() {
        return this.adminVo.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
