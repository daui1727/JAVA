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
		
		System.out.printf("문자를 하나 입력하세요.>");
		
		String input = scanner.nextLine();
		ch = input.charAt(0);   // charAt() --> string으로 저장된 문자열 중에서 한글자만 선택해 char 타입으로 변환해준다
		
		if('0'<=ch && ch<='9') {
			System.out.printf("입력하신 문자는 숫자입니다.%n");
		}
		
		if(('a'<=ch && ch<='z') || ('A'<=ch && ch<='Z')) {
			System.out.printf("입력하신 문자는 영문자입니다.%n");
		}
		

	}

}
