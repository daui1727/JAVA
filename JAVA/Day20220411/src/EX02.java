import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {
		
		
		
		// 5�Է� �� -> 5, 2�Է� �� -> 7, 8�Է� �� -> 15 �� ��µǵ���
		
//		int sum = 0; //������
//		int i = 0; //ȸ���뵵
//		int input;
//		
//		Scanner sc = new Scanner(System.in);
//		
//		while(i++ < 5) {
//			
//			System.out.print(i + "ȸ ���� �Է� : ");
//			input = sc.nextInt();
//			
//			sum += input;
//			System.out.println("sum : "+sum);
//		}
		
		/*------------------------------------------------------------------*/
		
//		int num;
//		int sum = 0;
//		boolean flag = true;  // while���� ���ǽ����� ���� ����
//		Scanner scanner = new Scanner(System.in);
//		
//		System.out.println("�հ踦 ���� ���ڸ� �Է��ϼ���.(�������� 0�� �Է�)");
//		
//		while(flag) {
//			System.out.print(">>");
//			String tmp = scanner.nextLine();
//			num = Integer.parseInt(tmp);
//			
//			if(num!=0) {
//				sum += num; // num�� 0�� �ƴϸ�, sum�� ���Ѵ�.
//			}else {
//				flag=false; // num�� 0�̸�, flag�� ���� false�� ����.
//			}
//		}
//		System.out.println("�հ� : " + sum);
		
		/*------------------------------------------------------------------*/
		
		for (int i = 1; i<=33; i++) {
			System.out.printf("i=%d ", i);
			
			int tmp = i;
			
//			do {
//				// tmp%10�� 3�� ������� Ȯ��(0����)
//				if(tmp%10%3==0 && tmp%10!=0)
//					System.out.print("¦");
//				// tmp/=10�� tmp=tmp/10�� ����
//			} while((tmp/=10) != 0);
			
			for(;;) {
				System.out.println("1 : " + tmp % 10);
				System.out.println("2 : " + (tmp % 10 % 3));
				
				if(tmp % 10 % 3 == 0 && tmp % 10 != 0)
					System.out.print("¦");
				
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
