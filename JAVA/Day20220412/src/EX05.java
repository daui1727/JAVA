import java.util.Scanner;

public class EX05 {

	public static void main(String[] args) {
		
		int input = 5;
		
		int i = 100;  // sub�� i�ʹ� �ٸ� ���̴�. �������
		
		sub(input);
		
		System.out.println("���α׷� ����!!!");
		
	}
	
	public static void sub(int n) {
		
		System.out.println("�Է��� " + n + "�� ���");
		for(int i=1; i<=9; i++)
			System.out.println(n*i);   // for���� i�� for�� �ӿ������� i�̴�.
		
	}

}
