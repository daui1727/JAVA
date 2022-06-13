import java.util.Scanner;

public class EX01 {

	// 두 정수를 입력 받아 합을 구하는 프로그램.
//	public static void main(String[] args) {  // jvm 호출
//
//		add();  // 함수 호출
//		
//		System.out.println("프로그램 종료");
//		
//	}
//	
//	// 입력(x) 출력(x) // void(반환형) add(함수이름) 
//	public static void add() {  //  -->  함수 정의, 함수 몸체
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		
//		System.out.println("두 수의 합은 " + (num1 + num2));
//	
//	
//	}
	
//	// 입력(o) 출력(x)
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		add(num1, num2);
//		System.out.println("프로그램 종료");
//		
//	}
//	public static void add(int num1, int num2) {
//		System.out.println("두 수의 합은 " + (num1 + num2));
//	}

	
//	// 입력(o) 출력(o)
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		
//		int result = add(num1, num2);
//		
//		System.out.println("두 수의 합은 " + result);
//		System.out.println("프로그램 종료");
//		
//	}
//	public static int add(int num1, int num2) {
//		return num1 + num2;
//	}

	
	// 두 정수의 입력을 받아서 평균을 구하는 프로그램
	// 입력(x) 출력(o)
	public static void main(String[] args) {
		
		
		double result = add();
		
		System.out.println("두 수의 평균은 " + result);
		System.out.println("프로그램 종료");
		
	}
	public static double add() {

		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		return (num1 + num2)/2.0;
	}
	
	
	
	
	
	
} // class 의 끝.
