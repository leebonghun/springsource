package com.company.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
			// 접근 제한시 해야 하는 자겅ㅂ들이 있따면 직접 핸들러를 구현
		log.info("접근 제한 핸들러");
		log.info("Redirect...");
		
		response.sendRedirect("/access-denied");
	}

}
