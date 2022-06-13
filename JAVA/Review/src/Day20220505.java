
public class Day20220505 {

	public static void main(String[] args) {

		A a = new B();
		A a1 = new C();    // 생성하는 인스턴스가 C라면
		B b1 = new B();
		
		C cc = (C)a1;    // C로 형변환 했을때 
		System.out.println(cc.a);  // 접근 가능하지만, 생성하는 인스턴스가 B 같이 하위클래스라면 접근 시 에러.
	
		/*----------------------------------------*/
		
		a1.test();
		
		
	}

}

class A{
	int a = 1;
	public A() {}
	public A(int a) {
		this.a = a;
	}
	void testA() {
		System.out.println("testA");
	}
	void test() {
		System.out.println("testA");
	}
}

class B extends A{

	int b = 2;
	public B() {}
	public B(int a, int b) {
		super(a);
		this.b = b;
	}
	void testB() {
		System.out.println("testB");
	}
	void test() {
		System.out.println("testB");
	}
}

class C extends B{
	
	int c = 3;
	public C() {}
	public C(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}
	
	void testC() {
		System.out.println("testC");
	}
	void test() {
		System.out.println("testC");
	}

}