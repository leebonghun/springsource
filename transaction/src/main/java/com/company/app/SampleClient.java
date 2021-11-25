package com.company.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.service.SampleService;

public class SampleClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config.xml");
		SampleService service = (SampleService) ctx.getBean("sample");
		
		String data = "Starry\r\n"
						+"Starry night\r\n"
						+"Paint your paletter blue and grey\r\n"
						+"Look out on a summer day";
		service.addData(data);
		
		
		
	}

}
