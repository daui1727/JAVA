

// 다형성에 대해 생각해보자.!!!!
public class EX01 {

	public static void main(String[] args) {

//			A c = new C();
//			c.testA();
//			C c = new A();   // ! 오류
			
		
			C c = new C(10,20,30);	
		
			System.out.println(c.a);
			System.out.println(c.b);
			System.out.println(c.c);
			
//			A c = new A();     // !오류!!!  
//			B cc = (B)c; 		// !오류!!!  A타입의 c를 B가 참조하게 되면 에러가 난다.
//			System.out.println(cc.a);   // !오류!!!   
			
		// 조상클래스 참조변수는 자손클래스 참조 가능
		// 자손클래스 참조변수는 조상클래스 참조 불가
			
			B cc = new C(10,20,30);
			cc.test();
	}

}

class A{
	int a;
	void test() {
		System.out.println("class A");
	}
	public A() {}
	public A(int a) {
		this.a = a;
	}
}
class B extends A{
	int b;
	void test() {
		System.out.println("class B");
	}
	public B() {}
	public B(int a, int b) {
		super(a);
		this.b = b;
	}
}
class C extends B{
	int c;
	void test() {
		super.test();
		System.out.println("class C");
	}
	public C() {}
	public C(int a, int b, int c) {
		super(a, b);
		this.c = c;
	}
	
}