import java.util.Scanner;

public class EX02 {

	/*
		    void    add    (int i, int j){} --> 함수 정의(몸체)
		    반환형   함수명      매개변수
		    
		     add   (10,20)  --> 함수 호출
		    함수명   인자,인자
		    
		    (인자 O, 반환 O)
		    (인자 O, 반환 X)
		    (인자 X, 반환 O)
		    (인자 X, 반환 X)    4가지 경우가 있다.
		    
		    >> 두 정수를 더하는 기능으로 함수 표현
		 
	 */
	
	
	public static void main(String[] args) {		

		int fee = 2500;
		int age = input();
		double rate = feeCalcRate(age);
		
		output(age,fee,rate);
		
		
	}  // end main

	static int input() {  // 입력
		
		int age = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print("나이 입력 : ");
		age = sc.nextInt();
		
		return age;
	}
	
	static double feeCalcRate(int age) { // 할인율 계산
		double rate = 0.0;
		
		if(age >= 65) {
			rate = 0;
		} else if (age >= 20) {
			rate = 1;
		} else if (age >= 14) {
			rate = 0.75;
		} else if (age >= 4) {
			rate = 0.5;
		} else {
			rate = 0;
		}
		return rate;
	}

	static void output(int age, int fee, double rate) {  // 출력
		System.out.println(age + "세 요금은 " + (int)(fee*rate));
	}
}
