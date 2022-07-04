package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

// xml에서 component-scan으로 Component가 붙은 것들을 메모리 공간에 올린다.
@Component
public class SamsungTV implements TV{
	
	// 메모리 공간에 speaker가 떠있다면 그걸 찾아서 집어넣는다.
//	@Autowired
//	@Qualifier("sonySpeaker")	// 메모리 공간에 speaker를 가진 클래스가 여러개가 떠있다면 qualifier로 특정한다.
	@Resource(name="sonySpeaker")
	private Speaker speaker;
//	private SonySpeaker speaker;
	private int price;
	
	
	
	public void setSpeaker(Speaker speaker) {
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
	
	public SamsungTV(Speaker speaker) {
		System.out.println("samsungTV 생성자(1개)");
		this.speaker = speaker;
	}
	
	public SamsungTV(Speaker speaker, int price) {
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
//		System.out.printf("가격 : %d\n", price);	
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
