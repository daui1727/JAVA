
public class EX03 {

	public static void main(String[] args) {

		
		// 3) �Լ����� �Է�(X), ���(O)�� ���
		double dnum = 2;
		int num2 = 5;
		
		System.out.println("main() �Լ�!!");
		
//		int result = sub();    // sub ȣ�� �� int num = 10000�� ��ȯ�Ǿ� result ���� �޾��ش�.
		double result = sub();    // sub ȣ�� �� int num = 10000�� ��ȯ�Ǿ� result ���� �޾��ش�.
		
		System.out.println("��� ���� "+ result);
		
		
	}
	
	
	// void �ڸ����� ��ȯ���� �´� --> void�� ��ȯ���� ���ٴ� ���� ���.
	// sub�� �Լ� �̸�. --> ���� �̸� �߿��� ����Ѵ�.
	public static double sub() {
		
//		int num = 10000;
		double dnum = 12.5;
		
		System.out.println("sub() �Լ�...");
		
//		return num;
		return dnum;
	}

}
