import java.util.Scanner;

public class EX01 {

	// �� ������ �Է� �޾� ���� ���ϴ� ���α׷�.
//	public static void main(String[] args) {  // jvm ȣ��
//
//		add();  // �Լ� ȣ��
//		
//		System.out.println("���α׷� ����");
//		
//	}
//	
//	// �Է�(x) ���(x) // void(��ȯ��) add(�Լ��̸�) 
//	public static void add() {  //  -->  �Լ� ����, �Լ� ��ü
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		
//		System.out.println("�� ���� ���� " + (num1 + num2));
//	
//	
//	}
	
//	// �Է�(o) ���(x)
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		add(num1, num2);
//		System.out.println("���α׷� ����");
//		
//	}
//	public static void add(int num1, int num2) {
//		System.out.println("�� ���� ���� " + (num1 + num2));
//	}

	
//	// �Է�(o) ���(o)
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		
//		int result = add(num1, num2);
//		
//		System.out.println("�� ���� ���� " + result);
//		System.out.println("���α׷� ����");
//		
//	}
//	public static int add(int num1, int num2) {
//		return num1 + num2;
//	}

	
	// �� ������ �Է��� �޾Ƽ� ����� ���ϴ� ���α׷�
	// �Է�(x) ���(o)
	public static void main(String[] args) {
		
		
		double result = add();
		
		System.out.println("�� ���� ����� " + result);
		System.out.println("���α׷� ����");
		
	}
	public static double add() {

		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		return (num1 + num2)/2.0;
	}
	
	
	
	
	
	
} // class �� ��.
