// 추상메서드 377p
public class EX04 {

	public static void main(String[] args) {
		
	}
}

abstract class Player{
	boolean pause;       // 일시정지 상태를 저장하기 위한 변수
	int currentPos;      // 현재 play 되고 있는 위치를 저장하기 위한 변수
	
	Player(){   // 추상클래스도 생성자가 있어야 한다.
		pause = false;
		currentPos = 0;
	}
	/* 지정된 위치(pos)에서 재생을 시작하는 기능이 수행하도록 작성되어야 한다. */
	
	abstract void play(int pos);   // 추상메서드
	/* 재생을 즉시 머무는 기능을 수행하도록 작성되어야 한다. */
	abstract void stop();  // 추상메서드
	
	void play() {
		play(currentPos); // 추상메서드를 사용할 수 있다.
	}
	
	void pause() {
		if(pause) {      // pause가 true일 때 (정지상태)에서 pause가 호출되면,
			pause = false;  // pause의 상태를 false로 바꾸고,
			play(currentPos);  // 현재의 위치에서 play를 한다.
		} else { // pause가 false일 때 (play상태)에서 pause가 호출되면
			pause = true;
			stop();
		}
	}
} // end Player

class CDPlayer extends Player{
	void play(int currentPos) {
		/* 조상의 추상메서드 구현. 내용 생략 */
	}
	void stop() {
		/* 조상의 추상메서드 구현. 내용 생략 */		
	}

	// CDPlayer 클래스에 추가로 정의된 멤버
	int currentTrack; // 현재 재생 중인 트랙
	void nextTrack() {
		currentTrack++;
	}
	void preTrack() {
		if(currentTrack > 1) {
			currentTrack--;
		}
	}
}




