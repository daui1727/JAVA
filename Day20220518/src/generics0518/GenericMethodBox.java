package generics0518;

class Box<T>{
	private T ob;
	public void set (T o) {ob = o;}
	public T get() {return ob;}
}

class BoxFactory{
	// 제네릭 메소드
	//   제네릭 메소드 표시 : <T>, Box<T> : 반환형,  T o : 매개변수
	public static <T> Box<T> makeBox(T o){
		Box<T> box = new Box<T>();
		box.set(o);
		return box;
	}
}

public class GenericMethodBox {

	public static void main(String[] args) {
			
		Box<String> sBox = BoxFactory.makeBox("Sweet");
		System.out.println(sBox.get());
		
		Box<Double> dBox = BoxFactory.makeBox(8.89);
		System.out.println(dBox.get());
		
	}

}
