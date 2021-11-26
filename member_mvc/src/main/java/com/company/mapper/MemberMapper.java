package com.company.mapper;

import org.apache.ibatis.annotations.Param;

import com.company.domain.MemberDTO;

public interface MemberMapper {
	public int insertMember(MemberDTO dto);
	
	//public MemberDTO selectMember(@Param("userid") String userid,@Param("password") String password);
	
	public MemberDTO selectId(String userid);
	
	public MemberDTO loginMember(@Param("userid") String userid,@Param("password") String password);
}
