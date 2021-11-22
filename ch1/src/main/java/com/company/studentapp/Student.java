package com.company.studentapp;

public class Student {
	private String name;
	private String age;
	private String gradeName;
	private String classNum;
	
	public Student(String name, String age, String gradeName, String classNum) {
		super();
		this.name = name;
		this.age = age;
		this.gradeName = gradeName;
		this.classNum = classNum;
	}

	public String getName() {
		return name;
	}

	

	public String getAge() {
		return age;
	}

	
	public String getGradeName() {
		return gradeName;
	}

	

	public String getClassNum() {
		return classNum;
	}

	
	
	
}
