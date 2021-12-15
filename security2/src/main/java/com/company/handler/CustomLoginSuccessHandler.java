package com.company.handler;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler  {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
			List<String> roleNames = new ArrayList<String>();
			authentication.getAuthorities().forEach(auth -> {
				roleNames.add(auth.getAuthority());
			});
			
			if(roleNames.contains("ROLE_USER")) {
				response.sendRedirect("/all");
				return;
			}
			if(roleNames.contains("ROLE_MEMBER")) {
				response.sendRedirect("/member");
				return;
			}
			if(roleNames.contains("ROLE_ADMIN")) {
				response.sendRedirect("/admin");
				return;
			}
			response.sendRedirect("/");
	}

}
