import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

// 요일에 해당하는 영문 소문자 입력하기

// 일 월 화 수 목 토 --> 랜덤하게 이 중 하나가 나오면
// 그에 맞는 소문자로 요일 입력  --> sunday, monday, tuesday, wednesday, thursday, friday, saturday

public class EX03 {

	public static void main(String[] args) {

		
		Scanner sc = new Scanner(System.in);
		
		String[] week_en = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
		String[] week_kr = {"일", "월", "화", "수", "목", "금", "토"};
		
		int retry = 0;
		int j = 0;
		
		// 내가 한거
//		do {
//			for(int i = 0; i < week_kr.length; i++) {
//				j = (int)(Math.random()*week_kr.length);
//			}
//		
//			while(true) {
//				System.out.print("\n"+week_kr[j]);		
//				System.out.print("요일을 영어 소문자로 입력 : ");
//				String day = sc.nextLine();
//				
//				if(day.equals(week_en[j])) break;
//				
//				System.out.println("오답입니다.");
//			}
//			
//			System.out.print("정답입니다 >> 재도전 (1) : 그만(0) : ");
//			retry = sc.nextInt();
//			sc.nextLine();
//			
//		}while(retry == 1);
//		
//		System.out.println("\n프로그램 종료!!");
		
		
		// 강사님이 한거
		Random rand = new Random();
		
		int last = -1;
		
		do {
			int day;
			do {
				day = rand.nextInt(7);
			}while(day==last);
			last = day;   // 최종 입력했던 요일이 저장된 상태
			
			while(true) {
				System.out.println(week_kr[day]);
				String dayeng = sc.nextLine();
				
				if(dayeng.equals(week_en[day])) break;
				
				System.out.println("오답입니다.");
			}
			System.out.println("정답입니다. 재시도(1) / 종료(0) : ");
			retry = sc.nextInt();
			sc.nextLine();  // 엔터키 제거용
			
		}while(retry == 1);
		  
		System.out.println("프로그램 종료!!");
		
		
		
		
		
		
		
	}  // end main

}
