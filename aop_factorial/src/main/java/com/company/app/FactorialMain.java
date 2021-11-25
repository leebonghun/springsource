package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.factorial.Calculator;

public class FactorialMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		Calculator cal =(Calculator)ctx.getBean("forc");
		System.out.println("=======================");
		System.out.println("for 10! = "+cal.factorial(10));
		System.out.println("=======================");
		cal =(Calculator)ctx.getBean("rec");
		System.out.println("recursive 10! = "+cal.factorial(10));
		System.out.println("=======================");
	}

}
