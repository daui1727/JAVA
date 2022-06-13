import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {
		
		
		
		// 5입력 시 -> 5, 2입력 시 -> 7, 8입력 시 -> 15 가 출력되도록
		
//		int sum = 0; //누적용
//		int i = 0; //회전용도
//		int input;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		while(i++ < 5) {
//			
//			System.out.print(i + "회 정수 입력 : ");
//			input = sc.nextInt();
//			
//			sum += input;
//			System.out.println("sum : "+sum);
//		}
		
		/*------------------------------------------------------------------*/
		
//		int num;
//		int sum = 0;
//		boolean flag = true;  // while문의 조건식으로 사용될 변수
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("합계를 구할 숫자를 입력하세요.(끝내려면 0을 입력)");
//		
//		while(flag) {
//			System.out.print(">>");
//			String tmp = scanner.nextLine();
//			num = Integer.parseInt(tmp);
//			
//			if(num!=0) {
//				sum += num; // num이 0이 아니면, sum에 더한다.
//			}else {
//				flag=false; // num이 0이면, flag의 값을 false로 변경.
//			}
//		}
//		System.out.println("합계 : " + sum);
		
		/*------------------------------------------------------------------*/
		
		for (int i = 1; i<=33; i++) {
			System.out.printf("i=%d ", i);
			
			int tmp = i;
			
//			do {
//				// tmp%10이 3의 배수인지 확인(0제외)
//				if(tmp%10%3==0 && tmp%10!=0)
//					System.out.print("짝");
//				// tmp/=10은 tmp=tmp/10과 동일
//			} while((tmp/=10) != 0);
			
			for(;;) {
				System.out.println("1 : " + tmp % 10);
				System.out.println("2 : " + (tmp % 10 % 3));
				
				if(tmp % 10 % 3 == 0 && tmp % 10 != 0)
					System.out.print("짝");
				
				if((tmp /= 10) == 0)
					break;
			}
			
			
			System.out.println();
		}
		
		/* 
		 for{
		  for
		 }
		 for{
		  while
		 }
		 for{
		 	do ~ while
		 }
		 while{
		 	while
		 }
		 while{
		 	for
		 }
		 */
		
		

	}

}
