import java.util.Scanner;

public class EX06 {

	public static void main(String[] args) {

		// 주사위 2개를 던져서 
		// (1,2)
		// (4,5)
		// (6,6)
		// (3,2) --> break  두 수의 합이 5가 되면 종료.
		
//		while(true) {
//			
//			int num1 = (int)(Math.random()*6)+1;
//			int num2 = (int)(Math.random()*6)+1;
//			
//			System.out.println("(" + num1 + "," + num2 + ")");
//			
//			if((num1 + num2) == 5) break;
//		}
		
		
		/*------------------------------------------------------------*/
		
		
		// 3자리 정수 양산프로그램
		
		Scanner sc = new Scanner(System.in);
		
		int retry = 0;
		System.out.println("암산하자");
		
		do {
			
			int x = (int)(Math.random()*100)+1;
			int y = (int)(Math.random()*100)+1;
			int z = (int)(Math.random()*100)+1;
			
			int num = (int)(Math.random()*4);
			
			int answer = 0;
			
			switch(num) {
			case 0: answer = x+y+z; break;
			case 1: answer = x+y-z; break;
			case 2: answer = x-y+z; break;
			default : answer = x-y-z; break;
			}
			
			while(true) {
				System.out.print(
						x + ((num < 2) ? "+" : "-") + 
						y + ((num%2 == 0) ? "+" : "-") + 
						z + "="
						);
				int an = sc.nextInt();
				if(an == answer) break;
				System.out.println("오답입니다.");
				
			}
			
			System.out.println("정답입니다. 한번 더(1) 종료(0) : ");
			retry = sc.nextInt();
			sc.nextLine();
			
		}while(retry == 1);
		
		System.out.println("프로그램 종료!!");
		
		
		
		
		
		
		
		
		
		
		
	} // end main

}
