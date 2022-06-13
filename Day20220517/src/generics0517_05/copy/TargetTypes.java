package generics0517_05.copy;

class Box<T>{
	protected T ob;
	public T getOb() {return ob;}
	public void setOb(T ob) {this.ob = ob;}
	
}

class EmptyBoxFactory{
	public static <T> Box<T> makeBox(){   // 지네릭 메소드 
		
		Box<T> box = new Box<T>();
		return box;
	
	}
}

	//Static 메서드의 호출.
		// Sample 클래스 내의 public static void display(){} 메소드를 다른 클래스에서 사용하려면
		// Sample.display();
		// 물론 Sample sp = new Sample();  sp.display()도 방법이지만 위와 같이 사용해야한다..


public class TargetTypes {

	public static void main(String[] args) {

//		Box<Integer> iBox = EmptyBoxFactory.makeBox();  // <> 생략가능. static 이라 이렇게 불러온..?
		
		
		Box<Integer> iBox = EmptyBoxFactory.<Integer>makeBox();
		
		iBox.setOb(25);
		
		System.out.println(iBox.getOb());
		
	}

}
