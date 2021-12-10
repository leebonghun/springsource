package com.mycompany.mych1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {

	public static void main(String[] args) {
		System.out.println("===============스프링 컨테이너 구동 전 =======");
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
		
		System.out.println("===============스프링 컨테이너 구동 =========");
		
		//스프링 컨테이너로부터 필요한 객체를 요청하는 부분
		MessageBean msg = (MessageBean)ctx.getBean("en"); //주입
		msg.sayHello("홍길동"); //실행
		
		
	}

}
