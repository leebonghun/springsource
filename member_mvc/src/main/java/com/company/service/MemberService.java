package com.company.service;

import org.apache.ibatis.annotations.Param;

import com.company.domain.MemberDTO;

public interface MemberService {
	public boolean insertMember(MemberDTO dto);
	
	public MemberDTO selectId(String userid);
	
	public MemberDTO loginMember(String userid,String password);
}
