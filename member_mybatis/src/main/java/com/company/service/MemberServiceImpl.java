package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.domain.ChangeDTO;
import com.company.domain.MemberDTO;
import com.company.mapper.MemberMapper;

@Service("memberservice")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper mapper;
	
	@Override
	public List<MemberDTO> list() {
		// TODO Auto-generated method stub
		return mapper.list();
	}

	@Override
	public MemberDTO read(String userid, String password) {
		// TODO Auto-generated method stub
		return mapper.read(userid, password);
	}

	

	@Override
	public boolean deleteMember(String userid) {
		// TODO Auto-generated method stub
		return mapper.deleteMember(userid)>0?true:false;
	}

	@Override
	public boolean updateMember(ChangeDTO changeDto) {
		// TODO Auto-generated method stub
		return mapper.updateMember(changeDto)>0?true:false;
	}

	@Override
	public boolean insertMember(MemberDTO changeDto) {
		// TODO Auto-generated method stub
		return mapper.insertMember(changeDto)>0?true:false;
	}

	

}
