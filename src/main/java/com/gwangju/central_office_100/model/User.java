package com.gwangju.central_office_100.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Entity
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean enabled;

    @Override
    // 사용자 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 반환 로직
        return null; // 예시를 위해 null로 설정
    }

    @Override
    // 사용자 비밀번호 반환
    public String getPassword() {
        return password;
    }

    @Override
    // 사용자 이름(주로 아이디) 반환
    public String getUsername() {
        return username;
    }

    @Override
    // 계정이 만료되지 않았는지 반환
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    // 계정이 잠겨 있지 않은지 반환
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    // 비밀번호가 만료되지 않았는지 반환
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    // 계정이 활성화되어 있는지 반환
    public boolean isEnabled() {
        return enabled;
    }
}
