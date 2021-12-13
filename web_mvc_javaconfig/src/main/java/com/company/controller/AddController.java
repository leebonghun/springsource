package com.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.domain.AddDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Controller
@RequestMapping("calc")
public class AddController {	

		@GetMapping("/add")
		//@RequestMapping(value="add",method =RequestMethod.GET)
		public void add() {
			log.info("하이 GET이네");
			
		}
//		@PostMapping("/add")
//		public void addPost(int num1,int num2,Model model) {
//			log.info("하이2 POST네");
//			
//			log.info(model.getAttribute(num1))
//		}
		@PostMapping("/add")
		public void addPost(AddDTO dto,Model model) {
			log.info(dto.getNum1()+","+dto.getNum2());
			
			int result = dto.getNum1()+dto.getNum2();
			
			model.addAttribute("result",result);
		}
		
		
}
