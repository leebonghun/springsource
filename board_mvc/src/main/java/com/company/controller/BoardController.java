package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.BoardDTO;
import com.company.service.BoardService;

import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/board/*")
public class BoardController {
		@Autowired
		private BoardService service;
	
	
	@GetMapping("register")
	public void register() {
		log.info("/board/register...");
	}
	
	@PostMapping("/register")
	public String registerPost(BoardDTO boardDTO,RedirectAttributes rttr) {
		log.info("Post로 요청.."+boardDTO);
		
		service.insertBoard(boardDTO);
		rttr.addFlashAttribute("result",boardDTO.getBno());
		//log.info("bno"+boardDTO.getBno());
			return "redirect:/board/list";
		
	}
	@GetMapping("/list")
	public void list(Model model) {
		log.info("list 요청중..");
		
		List<BoardDTO> list = service.list();
		
		model.addAttribute("list", list);
		
	}
	@GetMapping({"/read","/modify"})
	public void read(String bno,Model model) {
		log.info("read 요청중.."+bno);
		
		BoardDTO read = service.read(bno);
		
		model.addAttribute("read", read);
		
		
	}

	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto,RedirectAttributes rttr) {
		log.info("수정 진행중 ");
		
			service.modify(dto);
			rttr.addAttribute("bno", dto.getBno());
			return "redirect:/board/list";
	}
	@GetMapping("/remove")
	public void remove() {
		log.info("삭제 요청중...");
	}
	@PostMapping("/remove")
	public String removePost(String bno,HttpSession session) {
		
		if(service.remove(bno)) {
			session.invalidate();
			return "redirect:/board/list";
		}
		
		return "redirect:/board/modify";
	}
	
}
