import java.util.Scanner;

public class DayOfCalendar {

	// 달력 만들기
	
	// 윤년 계산
	private static boolean isLeapYear(int year) {
		
		boolean leap = false;
		
		if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
			leap = true;
		}
		return leap;
	}
	
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
			if(month == 1 || month == 3 || month == 5 || month == 7 ||month == 8 || month == 10 || month == 12) { 
		        tmp = 31; 
		      } else if(month == 4 || month == 6 || month == 9 || month == 11) { 
		        tmp = 30;
		      } else if (month == 2) { 
		        tmp = 28; 
		      } 
		}
		return tmp;  // tmp는 월의 끝자리
	} // end getDate
	
	// 해당 월의 첫번째 요일 계산
	private static int getDayOfWeek(int year, int month) {
		int dayOfWeek = 0;
		int sum = 0;
		
		// 1년 1월 1일 ~ year-1 년 12월 31일
		for(int i = 1; i < year; i++) {
			for(int j = 1; j <= 12; j++) {
				sum += getDate(i, j);
			}
		}
		
		// year 년 1월 1일 ~ year년 month-1 월 마지막(31,30,29,28)
		for(int k = 1; k < month; k++) {
			sum += getDate(year,k);
		}
		
		// year month 1일
		sum += 1;
		
		//요일
		dayOfWeek = sum % 7;
		
		return dayOfWeek;
	} // end getDayOfWeek
	
	/* --------------------------------------------------------- */
	public static void prn(int year, int month) {
		
		// 달력 윗부분 출력
		System.out.printf("\t\t%d년 %d월\n", year, month);
		System.out.printf("일\t월\t화\t수\t목\t금\t토\n");
		
		// 시작 요일
		int start = DayOfCalendar.getDayOfWeek(year, month);
		
		// 마지막 날짜
		int last = getDate(year, month);
		
		// 시작 요일만큼 빈공간
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
		
	}// end prn
	
	/* --------------------------------------------------------- */
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("연도 입력 : ");
		int year = sc.nextInt();
		System.out.print("월 입력 : ");
		int month = sc.nextInt();
		
		DayOfCalendar.prn(year, month);
	}
	
	
	
	
	
	

}
