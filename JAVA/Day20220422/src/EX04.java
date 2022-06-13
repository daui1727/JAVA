import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class EX04 {

	public static void main(String[] args) {

		
Scanner sc = new Scanner(System.in);
		
		Random rand = new Random();
		
		String[] week_en = {"sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday"};
		String[] week_kr = {"일", "월", "화", "수", "목", "금", "토"};
		
		int retry = 0;
		
		int last = -1;
		
		int count1 = 0, count2 = 0;
		
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
				count2++;
			}
			System.out.println("정답입니다. 재시도(1) / 종료(0) : ");
			retry = sc.nextInt();
			sc.nextLine();  // 엔터키 제거용
			count1++;
			
		}while(retry == 1);
		  
		
		System.out.println("성공 / 실패 횟수 : " + count1 + " / " + count2);
		System.out.println("프로그램 종료!!");
		
		
		
		
	}

}
