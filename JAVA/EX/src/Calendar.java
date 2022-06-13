import java.util.Scanner;

public class Calendar {

	// 달력 만들기
	
	// 윤년 계산
	private static boolean isLeapYear(int year) {
		
		boolean leap = false;
		if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
			leap = true;
		}
		return leap;
	} // end isLeapYear  --> 윤년 여부를 참 거짓으로 판별해서 leap 값을 리턴
	
	private static int getDate(int year, int month) {
		int tmp = 0;
		
		if(isLeapYear(year)) {
			switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				tmp = 31;
				break;
			case 4: case 6: case 9: case 11:
				tmp = 30;
				break;
			case 2:
				tmp = 29;
				break;
			} // end switch
		} else {
			switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				tmp = 31;
				break;
			case 4: case 6: case 9: case 11:
				tmp = 30;
				break;
			case 2:
				tmp = 28;
				break;
			} // end switch
		}
		return tmp;   
	} // end get Date  --> 입력 달의 마지막 날짜를 계산하여 tmp로 리턴
	
	/*----------------------------------------------------------------------*/
	
	private static int getDayOfWeek(int year, int month) {
		int dayOfWeek = 0;  // 총합을 7로 나눈 나머지 값으로 입력 달의 요일을 계산할 예정
		int sum = 0;  // 1년 1월 1일부터 입력달 전까지의 모든 날 총 합 수
		
		// 1년 1월 1일 부터 ~ 입력 year-1 12월 31일까지
		for(int i = 1; i < year; i++) {
			for(int j = 1;  j <= 12; j++) {
				sum += getDate(i, j);
			}
		}
		
		// 입력 year 1월 1일 ~ 입력 year 입력 month-1 (30,31,29,28)
		for(int k = 1; k < month; k++) {
			sum += getDate(year,k);
		}
		
		// 해당 월의 1일
		sum += 1;
		
		// 시작 요일을 알기 위해
		dayOfWeek = sum % 7;
		
		return dayOfWeek;
	} //end getDayOfWeek
	
	/*-------------------------------------------------------------------------*/
	
	public static void prn(int year, int month) {
		// 달력 윗부분 출력
		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		// 시작 요일
		int start = Calendar.getDayOfWeek(year, month);
		
		// 마지막 날짜
		int last = getDate(year, month);
		
		// 시작 요일만큼 빈 공간
		for(int i = 1; i <= start; i++) {
			System.out.print("\t");
		}
		
		// 달력 출력
		for(int i = 1; i <= last; i++) {
			System.out.printf("%d\t", i);
			start++;
			if(start%7 == 0) {
				System.out.println();
			}
		}
	} //end prn
	
	/*----------------------------------------------------------------------------*/
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();

		Calendar.prn(year, month);
	}

}
