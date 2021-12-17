package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class BasicController {
	
	
	@GetMapping("/main")
	public void main() {
		log.info("Hello My name is...");
		
		
	}
}
