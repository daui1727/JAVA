import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		
		/*
		
		int num = 4000; // 4000��  -->  �� �� ��
		
		int h = num / 3600;
		int m = num % 3600 / 60;
		int s = num % 60;
		
		System.out.println(num + "�ʴ� " + h + "��" + m + "��" + s + "���Դϴ�.");
		
		*/
		
		// Ű����� �� ���� �Է��� �޾Ƽ� , ������ ����� ����Ѵ�.
		
		Scanner sc = new Scanner(System.in);
		
		// int num1 = sc.nextInt();
		
		String n1 = sc.nextLine();
		String n2 = sc.nextLine();
		
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		
		int sum = num1 + num2;
		double aver = sum / 2.0;
		
		System.out.println(sum + " " + aver);
		
		
		
		

	}

}
