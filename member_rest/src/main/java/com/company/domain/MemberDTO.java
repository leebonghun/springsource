package com.company.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDTO {
	private String userid;
	private String password;
	private String new_password;
	private String confirm_password;
	private String name;
	private String gender;
	private String email;
	
}
