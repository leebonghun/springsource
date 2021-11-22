package ch2;

public class TvUser {

	public static void main(String[] args) {
//		SamsungTV tv = new SamsungTV();
//		
//		tv.powerOn();
//		tv.volumeUp();
//		tv.volumeDown();
//		tv.powerOff();
		
		
		//결합력을 낮추는 방식 => 다형성
		TV tv = new SamsungTV();
		tv.turnOn();
		tv.soundUp();
		tv.soundDown();
		tv.turnOff();
	}

}
