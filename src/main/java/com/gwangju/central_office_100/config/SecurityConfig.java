package com.gwangju.central_office_100.config;

import com.gwangju.central_office_100.model.Role;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests((authorizeRequests) -> authorizeRequests
                        .requestMatchers("/", "/index/**").permitAll()
                        .requestMatchers("posts/**", "/api/v1/posts/**").hasRole(Role.USER.name())
                        .requestMatchers("admins/**", "/api/v1/admins/**").hasRole(Role.ADMIN.name())
                        .anyRequest().authenticated()
                );
        return http.build();
    }
}
