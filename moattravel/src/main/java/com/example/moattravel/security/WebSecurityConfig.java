package com.example.moattravel.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity

public class WebSecurityConfig {

	@Bean

	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http

				.authorizeHttpRequests((requests) -> requests
						.requestMatchers( "/",
						        "/login",
						        "/signup",
						        "/signup/**",
						        "/signup/verify",
						        "/css/**",
						        "/js/**",
						        "/images/**",
						        "/storage/**",
						        "/houses",
						        "/houses/**").permitAll()
						//すべてのユーザーにアクセスを許可するURL

						.requestMatchers("/admin/**").hasRole("ADMIN")
						//管理者のみにアクセスを許可するURL

						.anyRequest().authenticated()
				//上記以外のURLはログインが必要（会員または管理者のどちらでもOK）

				)
				.formLogin((form) -> form//ログインページのURL
						.loginPage("/login")//ログインフォームの送信先URL
						.loginProcessingUrl("/login")//ログインフォーム
					    .usernameParameter("email")
					    .passwordParameter("password")  
						.defaultSuccessUrl("/?loggedIn", true)//ログイン字のリダイレクト先URL
						.failureUrl("/login?error")//ログイン失敗時のダイレクト先

						.permitAll())

				.logout((logout) -> logout
						.logoutSuccessUrl("/?loggedOut")//ログアウト時のリダイレクト先URL
						.permitAll());
		return http.build();
	}

	@Bean

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
