package com.company.tvapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TvUser {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		TV tv=(TV)ctx.getBean("samsung"); //앞자리를 소문자로 바꾼 클래스 이름
		

		tv.turnOn();
		tv.soundDown();
		tv.soundUp();
		tv.turnOff();
		
		
	
	}

}
