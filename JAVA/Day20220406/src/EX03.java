import java.util.Scanner;

public class EX03 {

	public static void main(String[] args) {

		
//		// 중첩 if.. 안쓰는게 좋음.
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		
//		if (num > 0) 
//			System.out.println("양수");
//		else {
//			if (num < 0)
//				System.out.println("음수");	
//			else
//				System.out.println("0");
//		}
		
		
		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		
//		if (str.equals("yes"))
//			System.out.println("정답입니다.");
		
//		if (str.equalsIgnoreCase("yes"))
//			System.out.println("정답입니다.");
		
		/*--------------------------------------------------------------------------*/
		
		int score = 0;
		char grade = ' ', opt = '0';
		System.out.print("점수를 입력해주세요. -> ");
		
		score = sc.nextInt();
		
		System.out.printf("당신의 점수는 %d입니다.%n",score);
		
		if (score >= 90) {
			grade = 'A';
			
			if (score >= 98) {
				opt = '+';
			} else if (score < 94) {
				opt = '-';
			}
		} else if (score >= 80) {
			grade = 'B';
			
			if (score >= 88) {
				opt = '+';
			} else if (score < 84) {
				opt = '-';
			}
		} else {
			grade = 'C';
		}
		System.out.printf("당신의 학점은 %c%c입니다.%n",grade,opt);
		
		sc.close();
	}

}
