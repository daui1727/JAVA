
public class GenericsEx2 {

	public static void main(String[] args) {
		
		
		Box2<Apple2> aBox = new Box2<Apple2>();  // Box2의 타입이 Apple2로 변환되는 것.
		
		Box2<Orange2> oBox = new Box2<Orange2>();
		
		aBox.setOb(new Apple2());
		oBox.setOb(new Orange2());
		
		Apple2 ap = aBox.getOb();   // 형변환을 할 필요가 없다.
		Orange2 or = oBox.getOb();
		
		System.out.println(ap);
		System.out.println(or);
		
	}

}

class Apple2{
	@Override
	public String toString() {
		return "I am apple";
	}
}

class Orange2{
	@Override
	public String toString() {
		return "I am orange";
	}
}

class Box2<T>{  
	private T ob;

	public T getOb() {
		return ob;
	}

	public void setOb(T ob) {
		this.ob = ob;
	}
	
}

