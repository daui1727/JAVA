import java.util.Scanner;

public class EX02 {

	static int num1, num2, num3;     // 정적변수, 클래스 변수 >> class안에서 공용으로 사용한다.
	public static void main(String[] args) {

		
		input();
		int max = Calc();
		output(max);
		
	} // end main

	static void input() {   // 입력부분
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수 3개 입력 : ");
		num1 = sc.nextInt();
		num2 = sc.nextInt();
		num3 = sc.nextInt();
		
	} // end input
	
	static int Calc() {
		int max = num1;
		
		if(num2 > max) {  //  Calc
			if(num2 > num3) {
				max = num2;
			}else {
				max = num3;
			}
		}else if(num3 > max) {
			max = num3;
		}
		return max;
	} // end Calc
	
	static void output(int num) {
		System.out.println("max : " + num);
	}
	
}
