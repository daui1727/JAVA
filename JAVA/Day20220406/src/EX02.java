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
		
		absX = x >= 0 ? x : -x;  // x�� ���� �����̸�, ����� �����.
 		absY = y >= 0 ? y : -y;
		absZ = z >= 0 ? z : -z;
		
		signX = x > 0 ? '+' : (x == 0 ? ' ' : '-');  // ���� �����ڸ� ��ø
 		signY = y > 0 ? '+' : (y == 0 ? ' ' : '-');
		signZ = z > 0 ? '+' : (z == 0 ? ' ' : '-');
		
		
		*/
		
		/*
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		if (num > 0) {
			System.out.println("���");
			System.out.println("akakakakakkakakakakak");
		}
		else if (num < 0)
			System.out.println("����");
		else
			System.out.println("0");
		 
		*/
		
		// ���� �Է� �޾Ƽ� 90�̻� A 80 B 70 C 60 D 60 ���� F
		
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
