import java.util.Scanner;

public class EX05 {

	public static void main(String[] args) {
		
		int input = 5;
		
		int i = 100;  // sub의 i와는 다른 값이다. 상관없음
		
		sub(input);
		
		System.out.println("프로그램 종료!!!");
		
	}
	
	public static void sub(int n) {
		
		System.out.println("입력한 " + n + "단 출력");
		for(int i=1; i<=9; i++)
			System.out.println(n*i);   // for문의 i도 for문 속에서만의 i이다.
		
	}

}
