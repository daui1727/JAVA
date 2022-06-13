package generics0518_04.copy;

class Box<T>{
	private T ob;
	public void set (T o) {ob = o;}
	public T get() {return ob;}
} 
	

public class GenericMethodBox {
	
	public static <T extends Number> void swapBox(Box<T> box1, Box<T> box2) {
		T tmp = box1.get();
		box1.set(box2.get());
		box2.set(tmp);
}

	public static void main(String[] args) {
			
		
		Box<Integer> box1 = new Box<>();
		box1.set(99);
		
		Box<Integer> box2 = new Box<>();
		box2.set(55);
		System.out.println("before : " + box1.get() + " & " + box2.get());
		
		swapBox(box1,box2);
		
		System.out.println("after : " + box1.get() + " & " + box2.get());
		
	}

}

/* 출력 >>>>>  before : 99 & 55
  			  after  : 55 & 99
 
   위 코드가 실행되도록 swapBox 메서드를 정의하라. 단, Box<T> 인스턴스를 인자로 전달 받을 수 있도록 정의
   그리고 이 때 Box<T> 인스턴스는 T는 Number 또는 이를 상속하는 하위 클래스만 올 수 있도록 제한한다.
 */