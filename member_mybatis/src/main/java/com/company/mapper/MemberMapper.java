package com.company.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.company.domain.ChangeDTO;
import com.company.domain.MemberDTO;

public interface MemberMapper {
	public List<MemberDTO> list();
	
	public MemberDTO read(@Param("userid") String userid,@Param("password") String password);
	
	public int updateMember(ChangeDTO changeDto);
	
	public int deleteMember(String userid);
	
	public int insertMember(MemberDTO changeDto);

}
