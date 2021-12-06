package com.company.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.ReplyDTO;
import com.company.service.ReplyService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/replies")
public class ReplyController {

	@Autowired
	private ReplyService service;

	@PostMapping("/new")
	public ResponseEntity<String> create(@RequestBody ReplyDTO insertDto) {
		log.info("댓글 입력..");

		return service.insertReply(insertDto) ? new ResponseEntity<String>("success", HttpStatus.OK) :

				new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/{rno}")
	public ResponseEntity<ReplyDTO> read(@PathVariable int rno) {
		log.info("dsad" + rno);

		return new ResponseEntity<ReplyDTO>(service.getRow(rno), HttpStatus.OK);

	}

	@PutMapping("/{rno}")
	public ResponseEntity<String> update(@PathVariable int rno, @RequestBody ReplyDTO updateDto) {

		// updateDto 세팅하기
		updateDto.setRno(rno);

		return service.updateReply(updateDto) ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{rno}")
	public ResponseEntity<String> delete(@PathVariable int rno) {

		return service.deleteReply(rno) ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
	}

	@GetMapping("/pages/{bno}/{page}")
	public ResponseEntity<List<ReplyDTO>> list(@PathVariable int bno) {

		return new ResponseEntity<List<ReplyDTO>>(service.list(bno), HttpStatus.OK);

	}
}
