import java.util.Scanner;

public class EX03 {

	public static void main(String[] args) {

		/*
		
		int a = 1;
		int b = 0;
		
		int i = 20;
		
		System.out.println(a>0 && b>0);
		System.out.println(a>0 || b>0);
		
		System.out.println(!(a>0 || b>0));
		
		System.out.println( i%2 == 0 || ( i%3 == 0 && i%6 != 0) );
		
		*/
		
		/*
		
		char ch = 'a';
		System.out.println(( ('a' <= ch && ch >= 'z') || ('A' <= ch || ch <= 'Z')));
		
		*/
		
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';
		
		System.out.printf("���ڸ� �ϳ� �Է��ϼ���.>");
		
		String input = scanner.nextLine();
		ch = input.charAt(0);   // charAt() --> string���� ����� ���ڿ� �߿��� �ѱ��ڸ� ������ char Ÿ������ ��ȯ���ش�
		
		if('0'<=ch && ch<='9') {
			System.out.printf("�Է��Ͻ� ���ڴ� �����Դϴ�.%n");
		}
		
		if(('a'<=ch && ch<='z') || ('A'<=ch && ch<='Z')) {
			System.out.printf("�Է��Ͻ� ���ڴ� �������Դϴ�.%n");
		}
		

	}

}
