
public class EX03 {

	public static void main(String[] args) {
		
		
		
		
		// ������ ���� ch�� ������(�빮�� �Ǵ� �ҹ���)�̰ų� ������ ���� ���� b�� ���� true�� �ǵ��� �ϴ� �ڵ�.
		
//		char ch = 'A';
//		boolean b = ('0'<=ch && ch <='9') || ('A'<=ch && ch <='Z') || ('a'<=ch && ch <='z');
//		
//		System.out.println(b);
		
		// �빮�ڸ� �ҹ��ڷ� �����ϴ� �ڵ�. ch�� ����� ���ڰ� �빮���� ��쿡�� �ҹ��ڷ� ����. �����ڵ�� �ҹ��ڰ� �빮�ں��� 32��ŭ �� ũ��.
		
//		char ch = 'B';
//		
//		char lowerCase = (ch>='A'&&ch<='Z') ? (char)(ch + 32) : ch;
//		
//		System.out.println("ch : " + ch);
//		System.out.println("ch to lowerCase : " + lowerCase);
		
		// ������ ������� ���ǽ����� ǥ���϶�.
		
		//int�� ���� x�� 10���� ũ�� 20���� ���� �� true�� ���ǽ�
		int x =11;
		
		System.out.println(x>10 && x<20);
		
		//char�� ���� ch�� �����̳� ���� �ƴ� �� true�� ���ǽ�
		char ch1 = ' ';
		
		System.out.println(ch1!=' ' && ch1!='\t');
		
		//char�� ���� ch�� 'x' �Ǵ� 'X'�� �� true�� ���ǽ�
		char ch2 = 'x';
		
		System.out.println(ch2=='x' || ch2=='X');
		
		//char�� ���� ch�� ����('0'~'9')�� �� true�� ���ǽ�
		char ch3 = '0';
		
		System.out.println(ch3>='0' && ch3<='9');
		
		//char�� ���� ch�� ������(�빮�� �Ǵ� �ҹ���)�� �� true�� ���ǽ�
		char ch4 = 'a';
		
		System.out.println((ch4>='A'&&ch4<='Z')||(ch4>='a'&&ch4<='z'));
		
		//int�� ���� year�� 400���� �����������ų� �Ǵ� 4�� ������������ 100���� ������������ ���� �� true�� ���ǽ�
		int year = 400;
		
		System.out.println(year%400==0 || (year%4==0 && year%100!=0));
		
		//boolean�� ���� powerOn�� false�� �� true�� ���ǽ�
		boolean powerOn = false;
		
		System.out.println(!powerOn);
		
		//���ڿ� �������� str��  "yes"�� �� true�� ���ǽ�
		String str = "yes";
		
		System.out.println(str.equals("yes"));
		
		
		

	}

}
