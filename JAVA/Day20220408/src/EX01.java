import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		
//		int sum = 0;
//		int i = 1;
//		
//		for (; i<6;) {   // �ʱ�ȭ ���� 7�� ��ó�� �̸� ��ΰ� ���� �����ϴ�.  // ������ ���� ��������. �� ��ġ�� �����ؾ��Ѵ�.
//			// sum += i++;    �̷� �����ε� ����.
//			sum += i;
//			System.out.println("i : " + i + ", sum = " + sum);
//			i++;
//		}
//		
//		System.out.println("Last sum = " + sum);
		
		
		/* ------------------------------------------------------------------------------------------ */
		
		System.out.print("����(1), ����(2), ��(3) �� �ϳ��� �Է��ϼ���. --> ");
		
		int user, com;
		
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		
		user = Integer.parseInt(tmp);
		com = (int)(Math.random()*3) + 1;
		
		System.out.println("����� " + user + "�Դϴ�");
		System.out.println("���� " + com + "�Դϴ�");
		
		if(user-com == 2 || user-com == -1) {
			System.out.println("����� �����ϴ�.");
		} else if(user-com == 1 || user-com ==-2) {
			System.out.println("����� �̰���ϴ�.");
		} else {
			System.out.println("�����ϴ�.");
		} // if���� ��
		
		
		
		
		

	} // main�� ��

}
