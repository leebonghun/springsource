package com.company.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	
	private MemberDTO member;

	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(MemberDTO member) {
		
		super(member.getUserid(),member.getUserpw(),member.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
		this.member = member;
	}
	
	

}
