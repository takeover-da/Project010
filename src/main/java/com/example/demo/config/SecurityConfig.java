package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  //스프링 설정 클래스
@EnableWebSecurity  //보안 설정
public class SecurityConfig {
	
	// 로그인 인증 처리를 위한 필터 체인
	// 필터 체인을 커스텀하여 생성하고 빈으로 등록
	/*
	 * @Bean public SecurityFilterChain filterChain(HttpSecurity http) throws
	 * Exception {
	 * 
	 * // 메뉴별 접근 권한 설정 // 회원가입: 아무나 접근 가능 http.authorizeRequests()
	 * .requestMatchers("/register").permitAll();
	 * 
	 * return http.build(); }
	 */
	// 회원가입시 사용자 패스워드를 암호화하는데 사용할 인코더
	// BCrypt: 암호화 알고리즘 종류 (단방향)
	@Bean  //빈을 생성하여 컨테이너에 저장
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
}
