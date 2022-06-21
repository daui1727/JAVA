package polymorphism;

public class sonyTV implements TV{
	public sonyTV() {
		System.out.println("sonyTV 생성자");
	}
	public void powerOn() {
		System.out.println("sony---전원 켠다.");	
	}
	public void powerOff() {
		System.out.println("sony---전원 끈다.");	
	}
	public void volumeUp() {
		System.out.println("sony---소리 올린다.");
	}
	public void volumeDown() {
		System.out.println("sony---소리 내린다.");
	}
}
