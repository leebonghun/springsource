package com.company.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.ChangeDTO;
import com.company.domain.MemberDTO;

public interface MemberService {
	public List<MemberDTO> list();
	
	public MemberDTO read(String userid,String password);
	
	public boolean updateMember(ChangeDTO changeDto);
	
	public boolean deleteMember(String userid);
	
	public boolean insertMember(MemberDTO changeDto);
}
