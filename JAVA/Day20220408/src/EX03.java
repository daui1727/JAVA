
public class EX03 {

	public static void main(String[] args) {

		
		
		// 1+(-2)+3+(-4)+.... �� ���� ������ ��� ���س����� ��, ����� ���ؾ� ������ 100�̻��� �Ǵ� �� ���϶�.
//		
//		int sum = 0;
//		int i = 0;
//		int sign = 1;
//		int tmp = 0;
//		
//		for(i=1; true; i++, sign = -sign) {    //sign 1, -1, 1, -1 ....
//			
//			tmp = i*sign;
//			sum += tmp;
//			
//			if(sum>=100) {
//				break;
//			}
//		}
//		System.out.println("i : " + i + " tmp : " + tmp + " sum : " + sum);
		
		/*----------------------------------------------------------------------------------------*/
		
//		int value = 0;
		
//		for (int i = 0; i<6; ++i)
//			System.out.println((int)(Math.random()*45)+1);
		
		/*----------------------------------------------------------------------------------------*/
		
//		for(int i=0; i<5; i++) {  // ��, ��
//			for(int j=0; j<=5; j++) {  // ��. ĭ
//				System.out.print("*");
//			}
//			System.out.println();  // �� �ٲ�
//		}
		
		
		/*----------------------------------------------------------------------------------------*/
		
		
		for(int i=2; i<10; i++) {
			
			for(int j=1; j<10; j++) {
				System.out.print(i + " x " + j + " = " + i*j + "\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		

	}

}
