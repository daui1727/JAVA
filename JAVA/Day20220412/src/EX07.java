
public class EX07 {

	public static void main(String[] args) {

		int input = 3;
		
		boolean flag = gugudan(input);
				
		if(flag == true)
			System.out.println("��� ����");
		else
			System.out.println("��� ����");
		
		}
			
	// �Է�(��), ���(��)
		public static boolean gugudan(int n) {
				
				
			boolean flag = true;
				
			System.out.println("�Է��� " + n + "�� ���");
			for(int i = 1; i <= 9; i++)
				System.out.println(n*i);
			
			return flag;
		}


}
