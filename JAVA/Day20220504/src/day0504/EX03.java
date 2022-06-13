package day0504;

public class EX03 {

	public static void main(String[] args) throws Exception{

		method1();
		
	}

	static void method1() throws Exception{
		method2();
	}

	static void method2() throws Exception{
		throw new Exception();
	}

}


// try catch로 예외처리를 하지 않은 예제.
// 단순히 2에서 1으로 1에서 메인으로 예외를 전달만 할 뿐 처리는 되지 않고 에러로 프로그램이 종료된다.