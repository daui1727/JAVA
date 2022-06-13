package generics0517_08.copy;

class Box<T>{
	protected T ob;
	public T getOb() {return ob;}
	public void setOb(T ob) {this.ob = ob;}
	
	@Override
	public String toString() {
		return ob.toString();
	}
}

class Unboxer{	

	public static void peekBox(Box<? super Integer> box) {  // 와일드카드  하한제한  // Integer의 조상들 가능.
													// Integer, Number, Object
		System.out.println(box);
	}
}


public class LowerBoundedWildcard {

	public static void main(String[] args) {

		Box<Integer> box = new Box<>();
		box.setOb(100);
		Unboxer.peekBox(box);
		
		Box<Number> box2 = new Box<>();
		box2.setOb(12.4);
		Unboxer.peekBox(box2);
		
		Box<Object> box3 = new Box<>();
		box3.setOb("String");
		Unboxer.peekBox(box3);
		
	}

}



//  copy 찾아볼것.
//  public static <T> void copy(List<? super T> dest, List<? extends T> src)

//  src가 dest로.
//  dest에는 어떤 값을 저장하는 용도. 꺼내는건 아니다. get 불가 set 사용 가능
//  src 부분은 읽기만 가능하다. 수정 불가.


