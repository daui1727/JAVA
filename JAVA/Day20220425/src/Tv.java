public class Tv{
	
	// 변수 == 인스턴스변수
	// tv의 속성(멤버변수)    
	String color;
	boolean power;
	int channel;
	
	// tv의 기능(메서드) == 인스턴스메서드
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}

class TvTest{
	public static void main(String[] args) {
		
		Tv t;
		t = new Tv();
		t.channel = 7;
		t.channelDown();
		System.out.println("현재 채널은 " + t.channel + " 입니다.");
		
		Tv t2 = new Tv();
		t2.channel = 10;
		t2.channelUp();
		System.out.println(t2.channel);
		
	}
}