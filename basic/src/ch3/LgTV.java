package ch3;

public class LgTV implements TV {
	
	private Speaker speaker;
	
	public LgTV() {
		
	}
	
	public LgTV(Speaker speaker) {
		super();
		this.speaker = speaker;
	}
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
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
		//System.out.println("LgTV - 볼륨 up");
//		speaker=new SonySpeaker();
		speaker.volumUp();
	}
	@Override
	public void soundDown() {
		//System.out.println("LgTV - 볼륨 down");
//		speaker=new SonySpeaker();
		speaker.volumDown();
	}
}
