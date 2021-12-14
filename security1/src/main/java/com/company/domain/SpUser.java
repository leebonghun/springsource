package com.company.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SpUser {
	private String userid;
	private String email;
	private boolean enable;
	private String password;
	
	//ROLE 정보 담기
	private List<SpUserAuthority> authorities;
}
