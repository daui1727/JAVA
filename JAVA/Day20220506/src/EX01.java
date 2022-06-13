
// 상위클래스는 하위클래스를 참조할 수 있고
// 하위클래스는 상위클래스를 참조할 수 없다.
// 단, 상위 클래스가 참조한 하위클래스를 하위클래스 참조변수에게 타입변환 후 참조하게 할 수 있다..

public class EX01 {

	public static void main(String[] args) {
		Object obj = new B(new D());
		
		B b = (B)obj;
		String s = b.abc();
		System.out.println(s);
	}

}

class A{
	int a;
	void funcA() {}
}

class B extends A{
	int b;
	void funcB(Object o) {}
	
	public B(Object o) {
		if(o instanceof D) {
			D de = (D)o;
			de.d = 10;
		}
	}
	String abc() {
		String aaa = "abc";
		return aaa ;
	}
}

class D{
	int d;
}