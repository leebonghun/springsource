package com.company.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.company.domain.LoginDTO;

public class LoginHandler implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		//session 정보를 확인해서 로그인 정보가 있다면 원하는 컨트롤러로 진입
		
		//session이 없다면 로그인 페이지로 이동
		
		HttpSession session = request.getSession();
		
		LoginDTO loginDto =(LoginDTO) session.getAttribute("loginDto");
		
		if(loginDto!=null) {
			return true; // /member/changePwd 컨트롤러로진입해라
			
		}
		response.sendRedirect("/member/signin");
		return false;
	}

}
