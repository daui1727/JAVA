
public class EX03 {

	public static void main(String[] args) {

		
	}

}

abstract class Player2{  // 추상클래스
	abstract void play(int pos);   // 추상 메서드
	abstract void stop();    // 추상 메서드
}

class AudioPlayer extends Player2{   // 추상클래스를 상속받는 자식클래스
	void play(int pos) {/*내용생략*/}  // 추상메서드를 구현
	void stop() {/*내용생략*/}  // 추상메서드를 구현
}

abstract class AbstractPlayer extends Player2{
	void play(int pos) {}   // 추상메서드를 구현
}