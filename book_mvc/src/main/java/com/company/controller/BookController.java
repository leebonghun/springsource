package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	@GetMapping("/read")
	public void read(String code,Model model) {
		
		log.info("헤헤..");
		BookDTO	bookDto = service.read(code);
			model.addAttribute("bookDto", bookDto);
	}
	

}
