import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {

		// if���� ����Ͽ� �ټ� �� ������ �Է¹޾Ƽ� ���� ū ���� ����ϴ� ���α׷� �ۼ�
		
		// �Է¹޴� ���ڴ� 0 ~ 100  ���� ���� 5�� �Է¹޾Ƽ� ū �� ���ϱ�
		
		Scanner sc = new Scanner(System.in);
		int num, max = 0, i = 0;
		String tmp;
		
		System.out.println("���� 5ȸ �Է� : ");
//		for(int i = 0; i < 5; i++) {
//			tmp = sc.nextLine();
//			num = Integer.parseInt(tmp);
//			if(num < 0 || num>100) {
//				--i;
//				continue;
//			}
//			if(max < num) max = num;
//		}
		
		while(i<5) {
			tmp = sc.nextLine();
			num = Integer.parseInt(tmp);
			if(num>0 && num<101) {
				if(max < num) max = num;
				i++;
			} else {
				System.out.println("0 �̻� 100���ϸ� �Է°���");
			}
		}
		
		System.out.println("�ִ밪 : " + max);
		
		
		
	}

}
