package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.ChangeDTO;
import com.company.domain.LoginDTO;
import com.company.domain.MemberDTO;
import com.company.mapper.MemberMapper;

@Service("service")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberMapper mapper;

	@Override
	public boolean insertMember(MemberDTO dto) {
		// TODO Auto-generated method stub
		return mapper.insertMember(dto)>0?true:false;
	}

	
	
	  @Override public MemberDTO selectId(String userid) {
	  
	  return mapper.selectId(userid); 
	  }



	@Override
	public LoginDTO login(LoginDTO loginDto) {
		// TODO Auto-generated method stub
		return mapper.loginMember(loginDto);
	}



	@Override
	public boolean updateMember(ChangeDTO changeDto) {
		// TODO Auto-generated method stub
		return mapper.updateMember(changeDto)>0?true:false;
	}



	@Override
	public boolean deleteMember(LoginDTO loginDto) {
		// TODO Auto-generated method stub
		return mapper.deleteMember(loginDto)>0?true:false;
	}



	
	 
}
