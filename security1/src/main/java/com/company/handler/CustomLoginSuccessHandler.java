package com.company.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		log.info("Login success");
		
		//로그인 성공시 ROLE 이 admin 이라면 admin-page로 이동
		//ROLE이 user 라면 user-page로 이동
		
		List<String> roleNames = new ArrayList<String>();
		authentication.getAuthorities().forEach(authority -> {
			roleNames.add(authority.getAuthority());
			
			
		});
		log.info("roleNames "+roleNames);
		
		if(roleNames.contains("ROLE_ADMIN")) {
			response.sendRedirect("/admin-page");
			return;
		}
		
		if(roleNames.contains("ROLE_USER")) {
			response.sendRedirect("/user-page");
			return;
		}
		response.sendRedirect("/");
		
	}
	
}
