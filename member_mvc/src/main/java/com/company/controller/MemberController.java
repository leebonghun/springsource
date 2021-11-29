package com.company.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;
import com.company.service.MemberService;

import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;

@Log4j2
@Controller
@RequestMapping("/member/*")
public class MemberController {

	@Autowired
	private MemberService service;

	// 로그인
	@GetMapping("/signin")
	public void signin() {
		log.info("로그인 요청");

	}

	// loginPost()
	@PostMapping("/signin")
	public String loginPost(LoginDTO loginDto, HttpSession session) {
		log.info(loginDto);
		
		loginDto = service.login(loginDto);
		session.setAttribute("loginDto", loginDto);

		return "redirect:/";

	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		log.info("로그아웃중..");
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/changePwd")
	public void changePwd() {
		log.info("비밀번호 변경중..");
	}

	@PostMapping("/changePwd")
	public String changePwdPost(ChangeDTO changeDto, HttpSession session) {
		log.info(changeDto);
		LoginDTO loginDto = (LoginDTO) session.getAttribute("loginDto");
		changeDto.setUserid(loginDto.getUserid());// loginDto에 있는 userid의 세션값을 changeDto에 있는 userid값을 넘기는 방법

		session.setAttribute("changeDto", changeDto);

		if (service.updateMember(changeDto)) {
			session.invalidate(); // 비밀번호 변경이 되면 기존의 세션 해제
			return "redirect:/member/signin";
		}
		return "redirect:/member/changePwd";

	}

	@GetMapping("/leave")
	public void leave() {
		log.info("로그아웃 처리중..");
	}

	@PostMapping("/leave")
	public String leaveOut(LoginDTO loginDto, HttpSession session) {
		
		if (service.deleteMember(loginDto)) {
			session.invalidate();
			return "redirect:/";
		}
		return "redirect:/member/leave";
	}
}
