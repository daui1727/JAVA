import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {
		
		
//		char gender;
//		String regNo ="";
//		
//		System.out.print("����� �ֹι�ȣ�� �Է��ϼ���.(000000-1111111) --> ");
//		
//		Scanner sc = new Scanner(System.in);
//		regNo = sc.nextLine();
//		
//		gender = regNo.charAt(7);  // �Է¹��� ��ȣ�� 8��° ���ڸ� gender�� ����.
//		
//		switch (gender) {
//		case '1' : case '3' :
//			System.out.println("����");
//			break;
//		case '2' : case '4' :
//			System.out.println("����");
//			break;
//		default:
//			System.out.println("��ȿ���� ���� �ֹε�Ϲ�ȣ�Դϴ�.");
//		}
//		
		/* --------------------------------------------------------------------------*/
		
		
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//			System.out.printf("1���� %2d ������ �� :  %2d%n", i, sum);
//		}
		
		/* --------------------------------------------------------------------------*/
		
		
//		for(int i=1,j=10; i<=10; i++,j--) {
//			System.out.printf("%2d \t %2d%n", i, j);
//		}
		
		/* --------------------------------------------------------------------------*/
		
//		int sum = 0;
//		for (int i = 1; true; i+=5) {
//			sum += i;
//			System.out.printf("1���� %3d ������ �� : %3d%n", i, sum);
//			
//			if(sum>=10000)
//				break;
//		}
		
		/* --------------------------------------------------------------------------*/
		
		// 1���� 20������ ���� �߿��� 2 �Ǵ� 3�� ����� �ƴ� ���� ������ ���Ͻÿ�.
		
		int sum = 0;
		for(int i=1; i<=20; i++) {
			if(i%2 != 0 && i%3 != 0)
			sum += i;
		}
		System.out.println("sum : " + sum);
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
