package generics0517_03.copy;

class Box<T extends Number>{  // T엔 객체가 올 수 있지만 제한을 두고 싶다면 extends 사용
							  // 이 경우 T에 올 수 있는 대상은 Number이거나 Number를 상속한 객체만 가능하다.
							  // Number 클래스는 Abstract 클래스로, 다음 클래스들은 Number 클래스를 상속한다.
							  // Short, Integer, Long, Float, Double, Byte 등
								
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	
	public T get() {
		return ob;
	}
}

class Person{}

public class BoundedBox {

	public static void main(String[] args) {
		
		
		Box<Double> aBox = new Box<>();
		// Box<String> aBox = new Box<>();  에러. Number 상속을 받지 않기 때문이다.
		aBox.set(100.1);
		
		System.out.println(aBox.get());
		
	}

}
