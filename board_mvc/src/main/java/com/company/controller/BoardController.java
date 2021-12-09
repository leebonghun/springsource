package com.company.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.company.domain.AttachFileDTO;
import com.company.domain.BoardDTO;
import com.company.domain.Criteria;
import com.company.domain.PageDTO;
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
		//첨부파일 확인하기
	//	if(boardDTO.getAttachList()!=null) {
	//		boardDTO.getAttachList().forEach(attach -> log.info(attach+""));
	//	}
		
		
		service.insertBoard(boardDTO);
		rttr.addFlashAttribute("result",boardDTO.getBno());
		//log.info("bno"+boardDTO.getBno());
			return "redirect:/board/list";
		
	}
	@GetMapping("/list")
	public void list(Model model,Criteria cri) {
		log.info("list 요청중.."+cri);
		
		List<BoardDTO> list = service.list(cri);
		
		//페이지 나누기를 위한 정보 얻기
		int totalCnt=service.totalCnt(cri);
		
		model.addAttribute("pageDto", new PageDTO(cri, totalCnt)); //다음페이지까지 cri 값이 유지된다
		model.addAttribute("list", list);
		
	}
	@GetMapping({"/read","/modify"})
	public void read(String bno,Model model,@ModelAttribute("cri") Criteria cri) {
		log.info("read 요청중.."+bno);
		
		BoardDTO read = service.read(bno);
		
		model.addAttribute("read", read);
		
		
	}

	@PostMapping("/modify")
	public String modifyPost(BoardDTO dto,Criteria cri,RedirectAttributes rttr) {
		log.info("수정 진행중 "+dto+"    "+cri);
		
			service.modify(dto);
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addFlashAttribute("result", "success");
			return "redirect:/board/list";
	}
	@GetMapping("/remove")
	public void remove() {
		log.info("삭제 요청중...");
	}
	@PostMapping("/remove")
	public String removePost(String bno,Criteria cri,RedirectAttributes rttr) {
		
	
			service.remove(bno);
			
			//페이지 나누기 값
			rttr.addAttribute("pageNum", cri.getPageNum());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			rttr.addFlashAttribute("result", "success");
			return "redirect:/board/list";
	}
	
	//첨부파일 관련 controller
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> getAttachList(int bno){
		log.info("파일첨부 중...."+bno);
		
		return new ResponseEntity<List<AttachFileDTO>>(service.findByBno(bno),HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
