package com.company.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;
import com.company.service.MemberService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController

public class MemerRestController {
	@Autowired
	private MemberService service;
	
	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody MemberDTO insertDto){
		
		log.info("회원가입.."+insertDto);
		if(service.insertMember(insertDto)) {
			return new ResponseEntity<String>("success",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
		
	}
	@PutMapping("/changePwd")
	public ResponseEntity<String> change(@RequestBody ChangeDTO changeDto){
		
		log.info("비밀번호 수정..");
		
		if(service.updateMember(changeDto)) {
			return new ResponseEntity<String>("success",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}
	@DeleteMapping("/leave")
	public ResponseEntity<String> delete(@RequestBody LoginDTO loginDto){
		log.info("회원탈퇴"+loginDto);
		if(service.deleteMember(loginDto)) {
			return new ResponseEntity<String>("success",HttpStatus.OK);
			
		}else {
			return new ResponseEntity<String>("fail", HttpStatus.BAD_REQUEST);
		}
	}
}
