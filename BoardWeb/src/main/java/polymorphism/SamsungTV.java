package polymorphism;

public class SamsungTV implements TV{
	
	private SonySpeaker speaker;
	private int price;
	
	
	
	public void setSpeaker(SonySpeaker speaker) {
		System.out.println("setSpeaker 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice 호출");
		this.price = price;
	}

	public SamsungTV() {
		System.out.println("samsungTV 생성자(default)");
	}
	
	public SamsungTV(SonySpeaker speaker) {
		System.out.println("samsungTV 생성자(1개)");
		this.speaker = speaker;
	}
	
	public SamsungTV(SonySpeaker speaker, int price) {
		System.out.println("samsungTV 생성자(2개)");
		this.speaker = speaker;
		this.price = price;
	}
	
	
//	public SamsungTV() {
//		System.out.println("SamsungTV 생성자");
//	}
//	void initMethod() {
//		System.out.println("initMethod 초기화 메서드");
//	}
//	
//	void BBB() {
//		System.out.println("BBB 소멸전 메서드");
//	}
	

	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");	
		System.out.printf("가격 : %d\n", price);	
	}
	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");	
	}
	public void volumeUp() {
//		System.out.println("SamsungTV---소리 올린다.");
//		speaker = new SonySpeaker();
		speaker.volumeUp();
	}
	public void volumeDown() {
//		System.out.println("SamsungTV---소리 내린다.");
//		speaker = new SonySpeaker();
		speaker.volumeDown();
	}
}
