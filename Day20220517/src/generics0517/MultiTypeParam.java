package generics0517;

class DBox<L,R>{  // 타입 매개변수는 보통 대문자로 E : Element,  K : Key, T : Type, V : Value 이런 식이다.
	private L left;
	private R right;
	
	public void set(L l, R r) {  // left에 String, right에 Integer 할당.
		left = l;
		right = r;
	}
	
	@Override
	public String toString() {
		return left + "&" + right;
	}
	
}

public class MultiTypeParam {

	public static void main(String[] args) {

		DBox<String, Integer> box = new DBox<String, Integer>();
		
		box.set("Apple", 20);  // 내부적으로 아래 50처럼 자동으로 변환해서 바꿔주지만 굳이 할 필요는 없다.
		System.out.println(box);
		box.set("Apple2", new Integer(50));
		System.out.println(box);
	}

}
