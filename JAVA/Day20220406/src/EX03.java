import java.util.Scanner;

public class EX03 {

	public static void main(String[] args) {

		
//		// ��ø if.. �Ⱦ��°� ����.
//		Scanner sc = new Scanner(System.in);
//		int num = sc.nextInt();
//		
//		if (num > 0) 
//			System.out.println("���");
//		else {
//			if (num < 0)
//				System.out.println("����");	
//			else
//				System.out.println("0");
//		}
		
		
		Scanner sc = new Scanner(System.in);
//		String str = sc.nextLine();
		
//		if (str.equals("yes"))
//			System.out.println("�����Դϴ�.");
		
//		if (str.equalsIgnoreCase("yes"))
//			System.out.println("�����Դϴ�.");
		
		/*--------------------------------------------------------------------------*/
		
		int score = 0;
		char grade = ' ', opt = '0';
		System.out.print("������ �Է����ּ���. -> ");
		
		score = sc.nextInt();
		
		System.out.printf("����� ������ %d�Դϴ�.%n",score);
		
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
		System.out.printf("����� ������ %c%c�Դϴ�.%n",grade,opt);
		
		sc.close();
	}

}
