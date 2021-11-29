package com.company.service;

import org.apache.ibatis.annotations.Param;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;

public interface MemberService {
	public boolean insertMember(MemberDTO dto);
	
	public MemberDTO selectId(String userid);
	
	public LoginDTO login(LoginDTO loginDto);
	
	public boolean updateMember(ChangeDTO changeDto);
	
	public boolean deleteMember(LoginDTO loginDto);
	
}
