package com.company.mapper;

import org.apache.ibatis.annotations.Param;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;

public interface MemberMapper {
	public int insertMember(MemberDTO dto);
	
	//public MemberDTO selectMember(@Param("userid") String userid,@Param("password") String password);
	
	public MemberDTO selectId(String userid);
	
	public LoginDTO loginMember(LoginDTO loginDto);
	
	public int updateMember(ChangeDTO changeDto);
	
	public int deleteMember(LoginDTO loginDto);
}
