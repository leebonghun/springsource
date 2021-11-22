package ch3;

public class SamsungTV implements TV {
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
