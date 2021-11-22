package com.company.tvapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser2 {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		LgTV tv=(LgTV)ctx.getBean("lg");
		
//		tv.setSpeaker(new AppleSpeaker());
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
		
		
		
		
	
	}

}
