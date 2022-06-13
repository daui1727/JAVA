package pack0428;

public class EX02 {

	public static void main(String[] args) {

	
	}

}

class Unit{
	private int x, y;
	
	void move(int x, int y) {/*지정된 위치로 이동*/}
	void stop() {/*현재 위치에 정지*/}
}

class Marine extends Unit{
	void stimPack() {/*스팀팩을 사용한다*/}
}

class Tank extends Unit{
	void changeMode() {/*공격모드를 변환한다*/}
}

class Dropship extends Unit{
	void load() {}
	void unload() {}
}