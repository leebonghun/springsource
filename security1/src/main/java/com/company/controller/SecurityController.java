package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
public class SecurityController {
	
	
	@GetMapping("/login")
	public String login() {
		log.info("로그인 폼 요청");
		return "/security/loginForm";
	}
	@GetMapping("/admin-page")
	public String adminPage() {
		log.info("admin 폼 요청");
		return "/security/adminPage";
	}
	@GetMapping("/user-page")
	public String userPage() {
		log.info("user 폼 요청");
		return "/security/userPage";
	}
	
	@PostMapping("/logout")
	public void logoutPost() {
		log.info("로그아웃");
	}
	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError","아이디나 비밀번호를 확인해주세요");
		return "/security/loginForm";
	}
}
