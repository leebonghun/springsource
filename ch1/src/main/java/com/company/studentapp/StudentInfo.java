package com.company.studentapp;

public class StudentInfo {
	private Student student;
	
	public StudentInfo() {
		System.out.println("StudentInfo 객체 생성 - 기본생성자");
	}

	public StudentInfo(Student student) {
		super();
		this.student = student;
		System.out.println("StudentInfo 객체 생성 - 인자를 받는 생성자");
	}
	
	public void setStudent(Student student) {
		this.student = student;
		System.out.println("Student 객체 생성");
	}
	public void getStudentInfo() {
//		if(student!=null) {
			System.out.println("==============================");
			System.out.println("이름 :"+student.getName());
			System.out.println("나이 :"+student.getAge());
			System.out.println("학년 :"+student.getGradeName());
			System.out.println("반 :"+student.getClassNum());
			System.out.println("==============================");
		//}
		
		
	}
}
