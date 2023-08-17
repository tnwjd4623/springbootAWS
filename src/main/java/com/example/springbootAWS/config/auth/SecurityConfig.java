package com.example.springbootAWS.config.auth;

import com.example.springbootAWS.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@RequiredArgsConstructor
@EnableWebSecurity  // spring security 설정 활성화
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable().headers().frameOptions().disable() // h2-console을 사용하기 위해 옵션 disable
                .and()
                    .authorizeRequests().antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll()
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())    // 권한 관리 대상, USER 권한을 갖는 사람만 가능하도록
                    .anyRequest().authenticated()   // 나머지 URL은 로그인한 사용자들에게 허용
                .and()
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService).and().and().build();  // 로그인 성공 후 후속조치
    }

}
