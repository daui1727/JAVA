
public class EX01 {

	public static void main(String[] args) {

		// 달력 만드는 예제
		
		int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
		int year = 0, month = 0, daysOfMonth = 0, firstDay = 0;
		int monthDays = 0;
		int totalDays;
		
		int daysOfWeek = 0;
		if(args.length != 2) {  // args 배열 - 실행 시 run configurations에 값 입력.
			year = 2022;
			month = 4;
		}else {
			year = Integer.parseInt(args[0]);
			month = Integer.parseInt(args[1]);
		}
		
		totalDays = (year*365);
		totalDays += (year-1)/4;
		totalDays -= (year-1)/100;
		totalDays += (year-1)/400;
		
		for(int i = 1; i < month; i++) {  // 해당 년도에서 입력한 달 전 달까지의 일 수를 해당 년도가 윤년인지 고려해서 계산
			if(i == 2) {
				if((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
					monthDays = 29;
				} else {
					monthDays = 28;
				}
			} else {
				monthDays = days[i-1];
			}
			totalDays += monthDays;
		} // for의 끝
		
		firstDay = totalDays%7;  // 해당 월 1일의 요일
		
		if(month == 2) {  // 윤년 여부를 판단해서 입력한 달의 날 수를 정한다.
			if((year%4 == 0) && (year%100 != 0) || (year%400 == 0)) {
				daysOfMonth = 29;
			}else {
				daysOfMonth = 28;
			}
		}else {
			daysOfMonth = days[month-1];
		}
		
		/* 최종 출력 */
		
		System.out.println(" " + year + "년" + month + "월");
		System.out.println(" 일 월 화 수 목 금 토");
		System.out.println("----------------------");
		for(int i = 0; i < firstDay; i++) {  // 해당 월 1일 요일이 일요일이 아니라면 앞부분을 공백으로 채운다.
			System.out.print(" ");
			daysOfWeek++;
		}
		
		for(int i = 1; i <= daysOfMonth; i++) {   // 줄바꿈과 공백
			if(i<10) {
				System.out.print(" "+i+"");
			}else {
				System.out.print(""+i+" ");				
			}
			daysOfWeek++;
			if(daysOfWeek%7 == 0) {
				System.out.println();
				daysOfWeek = 0;
			}
		}
		
		
		
		
		
		
		
	} // main의 끝

}
