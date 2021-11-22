package ch2;

public class LgTV implements TV {
	@Override
	public void turnOn() {
		System.out.println("LgTV - 전원 on");
	}
	@Override
	public void turnOff() {
		System.out.println("LgTV - 전원 off");
	}
	@Override
	public void soundUp() {
		System.out.println("LgTV - 볼륨 up");
	}
	@Override
	public void soundDown() {
		System.out.println("LgTV - 볼륨 down");
	}
}
