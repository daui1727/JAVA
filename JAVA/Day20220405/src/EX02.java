
public class EX02 {

	public static void main(String[] args) {
		
		/*
		
		float pi = 3.14159f;
		
		float result = (int)(pi*1000)/1000.0f;
		
		System.out.println(result);
		
		
		//3.142
		
		float result2 = (int)(pi*1000+0.5f)/1000f;
		
		System.out.println(result2);
		
		*/
		
		/*
		
		double pi = 3.141592;
		double shortPi = Math.round(pi * 1000) / 1000.0;  // Math.round() --> �ݿø� �޼���
		System.out.println(shortPi);

		*/
		
		/*
		
		int x = 10;
		int y = 8;
		System.out.println(x / y);
		System.out.println(x % y);   // %�� ������ ������
		System.out.println(x % -y);  // ������ ���� ��ȣ�� ���õȴ�
		System.out.println(-x % y);
		
		System.out.println();
		
		System.out.println(x > y);
		System.out.println(x < y);
		System.out.println(x >= y);
		System.out.println(x <= y);
		System.out.println(x == y);
		System.out.println(x != y);
		
		 */
		
		
		// Ŭ������ ��ü�� �����ؾ��Ѵ�. new �����ڷ� ����.
		String str1 = "abc";
		String str2 = new String("abc");
		
		System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc"=="abc");
		System.out.printf(" str1 == \"abc\" ? %b%n", str1=="abc");
		System.out.printf(" str2 == \"abc\" ? %b%n", str2=="abc");
		
		System.out.printf("str1.equals(\"abc\") ? %b%n", str1.equals("abc"));
		System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc"));
		System.out.printf("str2.equals(\"ABC\") ? %b%n", str2.equals("ABC"));
		System.out.printf("str2.equalsIgnoreCase(\"ABC\") ? %b%n", str2.equalsIgnoreCase("ABC"));
		
		
		
		
		
		
		
		
		
	}

}
