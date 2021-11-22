package com.company.tvapp;

import org.springframework.stereotype.Component;

@Component("apple")
public class AppleSpeaker implements Speaker {
	public AppleSpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("AppleSpeaker 객체 생성");
	}
	@Override
	public void volumUp() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker volume Up");
	}

	@Override
	public void volumDown() {
		// TODO Auto-generated method stub
		System.out.println("AppleSpeaker volume Down");
	}

}
