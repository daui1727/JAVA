import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		
		/*
		short num = (short)31000;  // short �� ���� �뷫 -32000 ~ +32000 ������ ���� ����� ��µȴ�.
		
		System.out.println(num);
		
		System.out.printf("%10d", num);
		System.out.printf("%d%n", num);
		
		*/
		/*-----------------------------------------------------------------------------------------------*/
		
		// ��ü        ��ü ����    --> new Ŭ������ Ŭ���� ��ü ����
		/*
		Scanner sc = new Scanner(System.in);
		
		String name = sc.nextLine();
		
		System.out.println(name);  // �̸��� �Է�
		
		//
		
		String input = sc.nextLine();
		
		int numb = Integer.parseInt(input);
		
		System.out.println(numb);  // ������ �Է�
		
		*/
		/*-----------------------------------------------------------------------------------------------*/
		
		char ch = 'A';   // char ch = 65;
		int code = (int)ch;   // ch�� ����� ���� intŸ������ ��ȯ�Ͽ� �����Ѵ�.
		
		System.out.printf("%c=%d(%#X) %n", ch, code, code);
		
		char hch = '가';  // char hch = 0xAC00;
		System.out.printf("%c=%d(%#X) %n", hch, (int)hch, (int)hch);
		
		
		
		
	}

}
