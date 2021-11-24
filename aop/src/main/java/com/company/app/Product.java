package com.company.app;

import org.springframework.stereotype.Component;

@Component
public class Product {
	private String company;
	private String pname;
	private String price;
	public Product(String company, String pname, String price) {
		super();
		this.company = company;
		this.pname = pname;
		this.price = price;
	}
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCompany(String company) {
		this.company = company;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public void getInfo() throws Exception {
		System.out.println("회사명 :"+company);
		System.out.println("제품명 :"+pname);
		System.out.println("가격 :"+price);
		throw new Exception();
		
	}
	
	
}
