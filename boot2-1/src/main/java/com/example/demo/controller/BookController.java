package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.BookDTO;
import com.example.demo.service.BookService;

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
	public String insertPost(BookDTO bookDto) {
		try {
			if (service.insertBook(bookDto)) {
				return "redirect:/book/list";
			}
		} catch (Exception e) {
			// TODO: handle exception
			return "/book/insert";
		}
		return "/book/insert";
	}

	@GetMapping("/list")
	public void list(Model model) {

		List<BookDTO> list = service.list();
		log.info(list);

		model.addAttribute("list", list);
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
