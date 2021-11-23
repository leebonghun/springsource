package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.service.PersonService;

public class PersonClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		
		PersonService service = (PersonService)ctx.getBean("person");
	
		//System.out.println(service.insertPerson("kang123", "강민섭")?"입력성공":"입력실패");
		
		//System.out.println(service.selectPerson("kang123"));
		
		//System.out.println(service.updatePerson("kang123", "이봉훈")?"수정성공":"수정실패");
		
		//System.out.println(service.deletePerson("kang123")?"삭제성공":"삭제실패");
	}

}
