
public class EX01 {

	public static void main(String[] args) {
		
		/*
		
		char c1 = 'A';  // c1에는 문자 'A'의 코드값인 65가 저장된다.
		int c2 = 65;
		char c3 = (char)c2;
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
	    */
		
		/*
	
		char c1 = 'a';
		char c2 = (char) (c1+1);
		char c3 = 'a'+1;
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);		
		
		*/
		
		int k = 0;
		int sum = 0;
		for (k=1; k<=5; k++) {
			sum+=1;
		}
		System.out.println("sum = " + sum);
		
		char c = 'a';
		for (int i = 0; i < 26; i++) {    // 블럭 {} 안의 문장을 26번 반복한다.
			System.out.print(c++);   // 'a' 부터 2개의 문자를 출력한다.
		}
		
		System.out.println();  // 줄바꿈을 한다.
		
		c = 'A';
		for (int i = 0; i < 26; i++) {  
			System.out.print(c++);
		}
		
		System.out.println();
		
		c = '0';
		for (int i = 0; i < 10; i++) {
			System.out.print(c++);
		}
		
		System.out.println();
		
	}

}
