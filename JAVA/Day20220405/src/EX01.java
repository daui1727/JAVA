
public class EX01 {

	public static void main(String[] args) {
		
		/*
		
		char c1 = 'A';  // c1���� ���� 'A'�� �ڵ尪�� 65�� ����ȴ�.
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
		for (int i = 0; i < 26; i++) {    // �� {} ���� ������ 26�� �ݺ��Ѵ�.
			System.out.print(c++);   // 'a' ���� 2���� ���ڸ� ����Ѵ�.
		}
		
		System.out.println();  // �ٹٲ��� �Ѵ�.
		
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
