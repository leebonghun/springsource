package com.company.tvapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
		TV tv=(TV)ctx.getBean("samsung");
		
//		tv.setSpeaker(new AppleSpeaker());
		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
		
		TV tv1=(TV)ctx.getBean("samsung");
		
		System.out.println(tv == tv1 ? "객체 동등":"객체 다름");
	
	}

}
