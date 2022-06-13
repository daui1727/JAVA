package day0504;

// 예제 9-7

// ! clone()을 사용하려면 복제할 클래스가 인터페이스 Cloneable를 구현해야하고,
// clone()을 오버라이딩하면서 접근 제어자를 protected에서 public으로 변경한다.
// 그래야 상속관계가 없는 다른 클래스에서 clone()을 호출 할 수 있다.
class Point implements Cloneable{  
	int x, y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "x = " + x + ", y = " + y;
	}
	
	public Object clone() {
		System.out.println("cloneclone");
		Object obj = null;
		
		try {
			obj = super.clone();    // clone() 반드시 예외처리 해주어야한다.
		} catch(CloneNotSupportedException e) {}
		
		return obj;
	}
}



public class EX08 {

	public static void main(String[] args) {

		Point original = new Point(3, 5);
		Point copy = (Point)original.clone();
		
		System.out.println(original);
		System.out.println(copy);
		
	}

}
