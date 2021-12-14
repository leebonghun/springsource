package com.company.mapper;

import org.apache.ibatis.annotations.Param;

import com.company.domain.SpUser;

public interface UserMapper {
	public int register(SpUser user);
	public int register_auth(@Param("userid") String userid,@Param("authority") String authority);
	public SpUser read(String userid);
}
