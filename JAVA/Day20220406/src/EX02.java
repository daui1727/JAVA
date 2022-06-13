import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {
		
		/*
		
		int x,y,z;
		int absX,absY,absZ;
		char signX, signY, signZ;
		
		x = 10;
		y = -5;
		z = 0;
		
		absX = x >= 0 ? x : -x;  // x의 값이 음수이면, 양수로 만든다.
 		absY = y >= 0 ? y : -y;
		absZ = z >= 0 ? z : -z;
		
		signX = x > 0 ? '+' : (x == 0 ? ' ' : '-');  // 조건 연산자를 중첩
 		signY = y > 0 ? '+' : (y == 0 ? ' ' : '-');
		signZ = z > 0 ? '+' : (z == 0 ? ' ' : '-');
		
		
		*/
		
		/*
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("양수");
			System.out.println("akakakakakkakakakakak");
		}
		else if (num < 0)
			System.out.println("음수");
		else
			System.out.println("0");
		 
		*/
		
		// 정수 입력 받아서 90이상 A 80 B 70 C 60 D 60 이하 F
		
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		
//		if (num >= 90 && num <= 100)
//			System.out.println("A");
//		else if(num < 90 && num >= 80)
//			System.out.println("B");
//		else if(num <80 && num >= 70)
//			System.out.println("C");
//		else if(num <70 && num > 60)
//			System.out.println("D");
//		else
//			System.out.println("F");
		
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num >= 90)
			System.out.println("A");
		else if(num >= 80)
			System.out.println("B");
		else if(num >= 70)
			System.out.println("C");
		else if(num > 60)
			System.out.println("D");
		else
			System.out.println("F");
		
		

	}

}
