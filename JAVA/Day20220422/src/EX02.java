import java.util.Scanner;

// 해당 월의 영어 단어를 입력하는 프로그램.
public class EX02 {

	public static void main(String[] args) {

		// MonthCal
		
		Scanner sc = new Scanner(System.in);
		
		String[] monthString = {
				"January", "February", "March", "April", "May", "June", 
				"July", "August", "September", "October", "November", "December"
		};
		
		System.out.println("해당 월의 영어 단어를 입력하세요.");
		System.out.println("첫 글자는 대문자, 그 이후는 소문자로 입력");
		
		
		int retry = 0;
		int last =  -1;  // 이전 월
		
		//  강사님이 한거
		
		do {   // 직전 월과 같은 월이면 반복 같은 달이 아니면 do ~ while 벗어남
			int month;
			do {
				month = (int)(Math.random()*12);
			}while(month == last);
			last = month;
			
			while(true){
				
				System.out.print((month+1) + "월 : ");
				
				String qus = sc.nextLine();
				
				if(qus.equals(monthString[month])) break;  // 정답
				
				System.out.println("오답입니다.");
			}
			
			System.out.println("정답입니다 >> 재도전 (1) : 그만(0) : ");
			retry = sc.nextInt();
			sc.nextLine();  // 버퍼에 들어간 엔터를 제거하기 위함
			
		}while(retry == 1);
		System.out.println("프로그램 종료!!");
		
		
		// 내가 해본거
//		do {
//			int month = (int)(Math.random()*12);
//			
//			while(true){
//					
//				if(month == last) {
//					month += 1;
//				}
//				System.out.print((month+1) + "월 : ");
//				
//				String qus = sc.nextLine();
//				
//				if(qus.equals(monthString[month])) break;  // 정답
//				
//				System.out.println("오답입니다.");
//			}
//			
//			System.out.println("정답입니다 >> 재도전 (1) : 그만(0) : ");
//			retry = sc.nextInt();
//			sc.nextLine();  // 버퍼에 들어간 엔터를 제거하기 위함
//			
//			last = month;
//			
//		}while(retry == 1);
//		System.out.println("프로그램 종료!!");
		
		// 처음에 해봤다가 오류난거
//		do {
//			int month = (int)(Math.random()*12);
//			
//			while(true){
//				
//				System.out.print((month+1) + "월 : ");
//				if(month == last){
//					continue;
//				}
//				
//				String qus = sc.nextLine();
//				
//				if(qus.equals(monthString[month])) break;  // 정답
//				
//				System.out.println("오답입니다.");
//			}
//			
//			System.out.println("정답입니다 >> 재도전 (1) : 그만(0) : ");
//			retry = sc.nextInt();
//			sc.nextLine();  // 버퍼에 들어간 엔터를 제거하기 위함
//			
//			last = month;
//			
//		}while(retry == 1);
//		System.out.println("프로그램 종료!!");
		
		
	}

}
