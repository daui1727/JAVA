import java.util.Scanner;

public class EXCAL {

	public static void main(String[] args) {
		
		//                       4년마다 윤년  100년마다 윤년 제외  400년 마다 윤년
		// day = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400 + 1
		
		int year = 0, month = 0, ttdays = 0, endDay = 0, endDay2 = 0;
		int i = 0, j =0;
		
		/* ---------------------------------------------- */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("연도 입력 : ");
		year = sc.nextInt();
		System.out.print("월 입력 : ");
		month = sc.nextInt();
		
		/* ---------------------------------------------- */

		// 월 일수 계산
				switch(month) {
				case 1: case 3: case 5: case 7: case 8: case 10: case 12:
					endDay = 31;
					break;
				case 4: case 6: case 9: case 11:
					endDay = 30;
					break;
				case 2:
					if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
						endDay = 29;
						break;
					} else { 
						endDay = 28;
						break;
					}
				}
		

		/* ---------------------------------------------- */

				// 총 일수 계산
				for(i = 1; i < year; i++) {
					if(i%4 != 0) {
						ttdays += 365;
					} else if(i%100 != 0) {
						ttdays += 366;
					} else if(i%400 != 0) {
						ttdays += 365;
					} else {
						ttdays += 366;
					}
				} // end for
				
				for(i = 1; i < month; i++) {
					switch(i) {
					case 1: case 3: case 5: case 7: case 8: case 10: case 12:
						endDay2 = 31;
						ttdays += endDay2;
						break;
					case 4: case 6: case 9: case 11:
						endDay2 = 30;
						ttdays += endDay2;
						break;
					case 2:
						if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
							endDay2 = 29;
							ttdays += endDay2;
							break;
						} else { 
							endDay2 = 28;
							ttdays += endDay2;
							break;
						}
					}
				}  // end for
				
				ttdays += 1;
		
		/* ---------------------------------------------- */
		
		int DayOfWeek = ttdays%7;  // 입력 월의 시작 요일
		
		// 달력 출력
		System.out.printf("%d년 %d월", year, month);
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.print("일\t월\t화\t수\t목\t금\t토\n");
		
		// 해당 월의 1일 전까지의 공백
		for(j = 1; j <= DayOfWeek; j++) {
			System.out.print("\t");
		}
		
		// 달력 표시 및 줄바꿈
		for(int k = 1; k <= endDay; k++) {
			System.out.printf("%d\t", k);
			DayOfWeek++;
			if(DayOfWeek%7 == 0) {
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println("---------------------------------------------------");

		 
		 
	} // end main

}
