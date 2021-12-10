package com.company.tvapp;

public class SamsungTV implements TV {
	public SamsungTV() {
		System.out.println("SamsungTv 객체 생성");
	}
	
	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV - 파워 on");
	}
	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV - 파워 off");
	}
	@Override
	public void soundUp() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV - 볼륨 up");
	}
	@Override
	public void soundDown() {
		// TODO Auto-generated method stub
		System.out.println("SamsungTV - 볼륨 down");
	}
}
