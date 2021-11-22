package com.company.tvapp;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("lg")
public class LgTV implements TV {
	//@Autowired //생성된 객체를 주입
	@Inject
	@Qualifier("apple") //이름 지정 기능밖에 없음
	private Speaker speaker;
	
	public LgTV() {
		System.out.println("LgTV 객체 생성");
	}
	
//	public LgTV(Speaker speaker) {
//		super();
//		this.speaker = speaker;
//	}
//	
//	public void setSpeaker(Speaker speaker) {
//		this.speaker = speaker;
//	}
	@Override
	public void turnOn() {
		System.out.println("LgTV - 전원 on");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTV - 전원 off");
	}
	@Override
	public void soundUp() {
		//System.out.println("LgTV - 볼륨 up");
//		speaker=new SonySpeaker();
		speaker.volumUp();
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTV - 볼륨 down");
//		speaker=new SonySpeaker();
		speaker.volumDown();
	}
}
