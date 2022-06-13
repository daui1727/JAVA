package generics0517_04.copy;

class Box<T>{
	protected T ob;

	public T getOb() {return ob;}

	public void setOb(T ob) {this.ob = ob;}
	
}

class SteelBox<T> extends Box<T>{
	public SteelBox(T t) {ob = t;}
}

public class GenericInheritance {

	public static void main(String[] args) {

		Box<Integer> iBox = new SteelBox<>(7959);
		Box<String> sBox = new SteelBox<>("simple");
		Box<Integer> zBox = new SteelBox("100");  // steelBox의 T가 정해지지않은..?
		
		// Raw Type : 타입 파라미터가 없는 제네릭 타입을 의미한다. 위에서는 SteelBox
		// Raw Type의 슈퍼 클래스는 Raw Type이다.
		// 상속 받지 않은 Raw Type의 생성자, 인스턴스 메서드, 인스턴스 필드는 Raw Type이다.
		// Raw Type은 타입 파라미터 T만 지워버리는 것이 아니라 슈퍼 클래스의 타입 파라미터도 지우고, 
		// 해당 클래스에 정의된 모든 타입 파라미터를 지워버린다
		
		
		System.out.println(iBox.getOb());
		System.out.println(sBox.getOb());
		System.out.println(zBox.getOb());
		
	}

}
