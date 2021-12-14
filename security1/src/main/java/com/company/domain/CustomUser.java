package com.company.domain;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class CustomUser extends User{
	
	private SpUser spUser;
		
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
	}

	public CustomUser(SpUser spUser) {
		super(spUser.getUserid(), spUser.getPassword(),spUser.getAuthorities().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuthority())).collect(Collectors.toList()));
		this.spUser = spUser;
	}
	
	

}
