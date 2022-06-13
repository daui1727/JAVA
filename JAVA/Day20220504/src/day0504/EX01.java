package day0504;

import java.util.InputMismatchException;
import java.util.Scanner;

// 예외처리

public class EX01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int sum = 0;
		
		try {
			int num = sc.nextInt();
			int a = 10/num;
//		}catch(ArithmeticException e) {
		}catch(InputMismatchException e1) {
			e1.printStackTrace();
		}catch(Exception e) {  // Exception이 최고 조상 클래스기 때문에 모든 예외를 처리한다. 이것만 써도 다 처리되지만.
								// 세분화하는 이유는 에러의 이유를 알기 편하게 하기 위해.
			e.printStackTrace();
		}finally {  // 무조건 거쳐간다.
			
		}
		for(int i = 0; i <= 100; i++) {
			sum += i;
		}
		System.out.println("sum = " + sum);
		
	}

}
