
public class EX02 {

	public static void main(String[] args) {

//		System.out.println("main() �Լ�!!");
//		sub2();  // ���ο��� �Ʒ� ���� �Լ��� ȣ���ؾ� ���� �Լ��� ����ȴ�.
//		System.out.println("main2() �Լ�!!");  // ���� �����Լ��� ���� ����ǰ� �� ���� ����.
//		
		
		// 2) �Լ����� �Է�(o), ���(x)�� ���.
		double dnum1 = 2;
		int num2 = 5;
		
		System.out.println("main() �Լ�!!");
		
		sub(dnum1,num2); // �Լ� ȣ��  // --> ���ڰ�. ���ڰ��� �Ű����� Ÿ���� ��ġ�ؾ��Ѵ�.
		
		System.out.println("main()2 �Լ�!!");
	}
	
//	// �Լ����� �Է�(x), ���(x) ���.
//	
//			// 1) �Լ��� �����ϸ� �ݵ�� �ٸ� ��(main ���) ȣ���� �ؾ��Ѵ�.
//			public static void sub() {
//				System.out.println("���� �Լ��Դϴ�.");
//			}
//			public static void sub2() {
//				sub();
//				System.out.println("���� �Լ�2�Դϴ�.");
//			}
	
	public static void sub(double i, int j) {  // ȣ�� �� ����ȯ�� �����ϵ��� Ÿ���� ��ġ�ؾ��Ѵ�.  // --> �Ű�����
		System.out.println("�� ���� ���� " + (i+j));
	}
	
}
