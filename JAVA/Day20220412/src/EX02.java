
public class EX02 {

	public static void main(String[] args) {

//		System.out.println("main() 함수!!");
//		sub2();  // 메인에서 아래 서브 함수를 호출해야 서브 함수가 실행된다.
//		System.out.println("main2() 함수!!");  // 위의 서브함수가 먼저 실행되고 난 이후 실행.
//		
		
		// 2) 함수에서 입력(o), 출력(x)의 경우.
		double dnum1 = 2;
		int num2 = 5;
		
		System.out.println("main() 함수!!");
		
		sub(dnum1,num2); // 함수 호출  // --> 인자값. 인자값과 매개변수 타입은 일치해야한다.
		
		System.out.println("main()2 함수!!");
	}
	
//	// 함수에서 입력(x), 출력(x) 경우.
//	
//			// 1) 함수가 존재하면 반드시 다른 곳(main 등에서) 호출을 해야한다.
//			public static void sub() {
//				System.out.println("서브 함수입니다.");
//			}
//			public static void sub2() {
//				sub();
//				System.out.println("서브 함수2입니다.");
//			}
	
	public static void sub(double i, int j) {  // 호출 시 형변환이 가능하도록 타입이 일치해야한다.  // --> 매개변수
		System.out.println("두 수의 합은 " + (i+j));
	}
	
}
