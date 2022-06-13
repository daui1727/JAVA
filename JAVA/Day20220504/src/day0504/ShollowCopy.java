package day0504;


// 한번더 생각해볼것.
public class ShollowCopy {

	public static void main(String[] args) throws CloneNotSupportedException {

		Rectangle org = new Rectangle(1,2,3,4);
		Rectangle cpy;
		
		cpy = (Rectangle) org.clone();
		org.showPosition();
		cpy.showPosition();
		
		org.changePos(3, 3, 7, 7);
		org.showPosition();
		cpy.showPosition();
	}

}

class Rectangle implements Cloneable{
	private nPoint upperLeft;    // 좌측 상단 좌표
	private nPoint lowerRight;   // 우측 하단 좌표
	
	public Rectangle(int x1, int y1, int x2, int y2) {
		upperLeft = new nPoint(x1,y1);
		lowerRight = new nPoint(x2, y2);
	}
	
	public void changePos(int x1, int y1, int x2, int y2) {   // 좌표 수정
		upperLeft.changePos(x1, y1);
		lowerRight.changePos(x2, y2);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void showPosition() {    // 사격형 좌표 출력
		System.out.println("좌측 상단");
		upperLeft.ShowPosition();
		
		System.out.println("우측 하단");
		lowerRight.ShowPosition();
	}
	
}

class nPoint implements Cloneable{
	private int xPos;
	private int yPos;
	
	public nPoint(int x, int y) { // 변수 이름이 달라서 this를 사용하지 않았다.
		xPos = x; yPos = y;
	}
	
	public void changePos(int x, int y) {
		xPos = y;
		yPos = x;
	}
	
	public void ShowPosition() {
		System.out.printf("[%d, %d]\n", xPos, yPos);
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
