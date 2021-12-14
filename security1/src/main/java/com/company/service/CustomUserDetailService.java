package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.company.domain.CustomUser;
import com.company.domain.SpUser;
import com.company.mapper.UserMapper;

import lombok.extern.log4j.Log4j2;
@Log4j2
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("-------------userid----------------"+username);
		
		SpUser spUser = mapper.read(username);
		
		log.info("인증 정보 : "+spUser);
	
		return new CustomUser(spUser);
	}
	

}
