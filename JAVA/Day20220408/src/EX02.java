import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {
		
		
//		char gender;
//		String regNo ="";
//		
//		System.out.print("당신의 주민번호를 입력하세요.(000000-1111111) --> ");
//		
//		Scanner sc = new Scanner(System.in);
//		regNo = sc.nextLine();
//		
//		gender = regNo.charAt(7);  // 입력받은 번호의 8번째 문자를 gender에 저장.
//		
//		switch (gender) {
//		case '1' : case '3' :
//			System.out.println("남자");
//			break;
//		case '2' : case '4' :
//			System.out.println("여자");
//			break;
//		default:
//			System.out.println("유효하지 않은 주민등록번호입니다.");
//		}
//		
		/* --------------------------------------------------------------------------*/
		
		
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//			System.out.printf("1부터 %2d 까지의 합 :  %2d%n", i, sum);
//		}
		
		/* --------------------------------------------------------------------------*/
		
		
//		for(int i=1,j=10; i<=10; i++,j--) {
//			System.out.printf("%2d \t %2d%n", i, j);
//		}
		
		/* --------------------------------------------------------------------------*/
		
//		int sum = 0;
//		for (int i = 1; true; i+=5) {
//			sum += i;
//			System.out.printf("1부터 %3d 까지의 합 : %3d%n", i, sum);
//			
//			if(sum>=10000)
//				break;
//		}
		
		/* --------------------------------------------------------------------------*/
		
		// 1부터 20까지의 정수 중에서 2 또는 3의 배수가 아닌 수의 총합을 구하시오.
		
		int sum = 0;
		for(int i=1; i<=20; i++) {
			if(i%2 != 0 && i%3 != 0)
			sum += i;
		}
		System.out.println("sum : " + sum);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
