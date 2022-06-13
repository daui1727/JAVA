import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {

		
		// 문제
		// 2022년 4월
		// 일 월 화 수 목 금 토
		//              1 2
		//  3 4 5  6 7  8 9
		//
		//               30
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("년도 입력 : ");
		String year_input = sc.nextLine();
		
		System.out.print("월 입력 : ");
		String month_input = sc.nextLine();
		
		System.out.println(year_input + " " + month_input);
	}

}
