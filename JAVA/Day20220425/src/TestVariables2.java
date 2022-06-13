
public class TestVariables2 {

	public static void main(String[] args) {

//		Variables2 var = new Variables2();
//		System.out.println(var.iv);
		
		System.out.println(Variables2.cv);  // 클래스 변수는 객체를 생성하지 않고 접근이 가능하다. 이유는 객체 생성 전에
		// 메모리 공간에 올라가있기 때문이다.
		
		Variables2 var2 = new Variables2();
		var2.method();   // 메서드는 객체 생성 후 접근 가능
		Variables2.method2();  
	}

}

class Variables2{
	int iv;         // 인스턴스변수, 멤버변수
	static int cv;  // 클래스 변수, 정적변수, 공유변수
	
	void method() {
		int iv = 0;    // 지역변수
	}

	static void method2() {
		int iv = 0;    // 지역변수
		System.out.println("iv = " + iv);
	}
}
