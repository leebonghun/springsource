package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.BookDTO;
import com.company.service.BookService;

import lombok.extern.log4j.Log4j2;
import oracle.jdbc.proxy.annotation.Post;

@Controller
@Log4j2
@RequestMapping("/book/*")
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping("/insert")
	public void insert() {
		log.info("insert 요청중..");

	}

	@PostMapping("/insert")
	//@ResponseBody // 일반 컨트롤러에서 RestController와 같은 역할 데이터로 인식해줌
	public ResponseEntity<String> insertPost(@RequestBody BookDTO bookDto) {
		try {
			if (service.insertBook(bookDto)) {
				return new ResponseEntity<String>("success", HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/list")
	public void list() {

		log.info("list 뽑아오는중..");
	}
	@GetMapping({"/read","/modify"})
	public void read(String code,Model model) {
		
		log.info("read or modify 요청.."+code);
		BookDTO	bookDto = service.read(code);
		model.addAttribute("bookDto", bookDto);
	}
	
	//book/remove
	@GetMapping("/remove")
	public String remove(String code) {
		log.info("삭제 요청중");
	
		if(service.deleteBook(code)) {
			return "redirect:/book/list";
		}
		return "redirect:/book/list";
	}
	@PostMapping("/update")
	public String update(BookDTO bookDto,RedirectAttributes rttr) {
		
		service.updateBook(bookDto);
		rttr.addAttribute("code", bookDto.getCode());
		return "redirect:/book/read";
	}
	
	
	

}
