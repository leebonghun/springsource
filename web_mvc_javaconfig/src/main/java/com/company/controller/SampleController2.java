package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller  //객체 생성하는 annotation

public class SampleController2 {
	
	@GetMapping("/member/basic")
	public void basic() {
		
		log.info("/member/basic 요청............");
		
	}

	
	
	//GET방식에만 응답하는 컨트롤러
	//@RequestMapping(value="/member/login",method=RequestMethod.GET)
	@GetMapping("/member/login")
	public String login() {
		log.info("/member/login 요청............");
		return "login";
	}
	
	@PostMapping("/member/login")
	public String loginPost() {
		log.info("/member/login Post 요청");
		return "/sample/basic";
	}
	
	//@RequestMapping(value="/admin/info",method=RequestMethod.GET)
	@GetMapping("/admin/info")
	public void method1() {
		log.info("/admin/info 요청.....");
		//ViewResolver : 주소 그대로
	}
	
	@GetMapping("/admin")
	public String method2() {
		log.info("/admin 요청..");
		return "admin";
	}
}
