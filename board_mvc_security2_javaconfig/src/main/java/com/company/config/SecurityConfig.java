package com.company.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

import com.company.handler.CustomLoginSuccessHandler;
import com.company.service.CustomUserDetailsService;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public PasswordEncoder passwordencoder() {
			return new BCryptPasswordEncoder();
	}
	
	@Bean
	public AuthenticationSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}
	@Bean
	public UserDetailsService customUserDetails() {
		return new CustomUserDetailsService();
	}
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl resp = new JdbcTokenRepositoryImpl();
		resp.setDataSource(dataSource);
		return resp;
	}	
	
	//security-context.xml을 변경해서
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//한글깨짐현상을 위해서 여기로 옮김
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("utf-8");
		filter.setForceEncoding(true);
		http.addFilterBefore(filter, CsrfFilter.class);
		
		
		http.formLogin().loginPage("/login").successHandler(loginSuccessHandler());
		http.logout().logoutUrl("/customLogout").invalidateHttpSession(true).deleteCookies("remember-me","JSESSION_ID").logoutSuccessUrl("/");
		http.rememberMe().tokenRepository(persistentTokenRepository()).tokenValiditySeconds(604800);
	}
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(customUserDetails()).passwordEncoder(passwordencoder());
	}}
	
