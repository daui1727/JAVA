
public class EX04 {

	public static void main(String[] args) {

		
		
		System.out.println("main() �Լ�!!");
		
		int result =  sub(5,10);  // �Լ� ȣ��  -->  ���ڰ�
		
		System.out.println("��� ���� " + result);
			
	}
	
	public static int sub(int i, int j) {
		
		int num = i*j;
		
		System.out.println("sub() �Լ�...");
		
		return num;
	}

}
