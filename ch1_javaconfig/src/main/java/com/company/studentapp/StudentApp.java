package com.company.studentapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {

	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationConfig.xml");
		StudentInfo info = (StudentInfo)ctx.getBean("info");
		
		info.getStudentInfo();
		
	}

}
