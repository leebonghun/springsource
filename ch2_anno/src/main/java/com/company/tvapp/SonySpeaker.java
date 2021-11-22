package com.company.tvapp;

import org.springframework.stereotype.Component;

@Component("sony")//객체생성해줘라!
public class SonySpeaker implements Speaker {
	public SonySpeaker() {
		System.out.println("SonySpeaker 객체 생성");
	}
	
	@Override
	public void volumUp() {
		System.out.println("SonySpeaker -- 볼륨 업");
		
	}
	@Override
	public void volumDown() {
		System.out.println("SonySpeaker -- 볼륨 다운");
		
	}
		
}
