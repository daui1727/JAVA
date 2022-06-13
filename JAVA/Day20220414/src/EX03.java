import java.util.Scanner;

public class EX03 {

	public static void main(String[] args) {

		// º¹½À
		
		char upperCase = 'A';
		char lowerCase = (char)(upperCase + 32);
		
		System.out.println(lowerCase);
		
		float pi = 3.141592f;  // -> 3.142
		float shortPi = (int)(pi*1000+0.5)/1000f;
		
		System.out.println(shortPi);
		
		/* ------------------------------------------------ */
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = "java";
		String s2 = "java";
		
		System.out.println(s1 == s2);
		
		String s3 = new String("java");
		String s4 = new String("java");
		
		
		System.out.println(s3 == s4);
		
		System.out.println(s3.equals(s4));

		String s5 = sc.nextLine();
		
		System.out.println(s3 == s5);
		System.out.println(s3.equals(s5));
	}

}
