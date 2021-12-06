package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.MemberDTO;
import com.company.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/register/*")
public class RegisterController {
	
	@Autowired
	private MemberService service;
	
	@GetMapping("/step1")
	public void registGet() {
		log.info("step1......");
		
		
	}
	
	@PostMapping("/step2")
	public String step2(boolean agree,RedirectAttributes rttr) {
		log.info("step2..."+agree);
		
		if(!agree) {
			rttr.addFlashAttribute("check", "false");
			return "redirect:/register/step1";
		}
		return "/register/step2";
	}
	
	//중복 아이디 검사
	@ResponseBody //return 하는 값이 일단 데이터(jsp페이지 안찾음)
	@PostMapping("checkId")
	public String idCheck(String userid) {
		log.info("중복 아이디 검사중..."+userid);
		
		if(service.selectId(userid)!=null) {
			return "false";
		}
		return "true";
	}
	@PostMapping("/step3")
	public String step3(Model model,MemberDTO dto) {
		log.info("/go to signin...");
		
		//boolean result=service.insertMember(dto);
		
		try {
			if(!service.insertMember(dto)) {
				return "/register/step2";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "/register/step2";
		}
		
		return "redirect:/member/signin";
			
//		model.getAttribute(dto.getUserid());
//		model.getAttribute(dto.getPassword());
//		model.getAttribute(dto.getConfirm_password());
//		model.getAttribute(dto.getName());
//		model.getAttribute(dto.getGender());
//		model.getAttribute(dto.getEmail());
		
		
	
		
		
	}
	
	//들어오면 안되는 경로를 요청하게 되면 원하는 페이지로 돌릴수있음
	@GetMapping(value= {"/step2","/step3"})
	public String handleGet() {
		log.info("/step2, /step3 직접 요청..");
		
		//step2,step3를 주소창에 입력하면 자동적으로 step1으로 이동
		return "redirect:/register/step1";
	}
	
	
	
	
}
