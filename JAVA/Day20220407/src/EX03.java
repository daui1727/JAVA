
public class EX03 {

	public static void main(String[] args) {
		
		
		
		
		// 문자형 변수 ch가 영문자(대문자 또는 소문자)이거나 숫자일 때만 변수 b의 값이 true가 되도록 하는 코드.
		
//		char ch = 'A';
//		boolean b = ('0'<=ch && ch <='9') || ('A'<=ch && ch <='Z') || ('a'<=ch && ch <='z');
//		
//		System.out.println(b);
		
		// 대문자를 소문자로 변경하는 코드. ch에 저장된 문자가 대문자인 경우에만 소문자로 변경. 문자코드는 소문자가 대문자보다 32만큼 더 크다.
		
//		char ch = 'B';
//		
//		char lowerCase = (ch>='A'&&ch<='Z') ? (char)(ch + 32) : ch;
//		
//		System.out.println("ch : " + ch);
//		System.out.println("ch to lowerCase : " + lowerCase);
		
		// 다음의 문장들을 조건식으로 표현하라.
		
		//int형 변수 x가 10보다 크고 20보다 작을 때 true인 조건식
		int x =11;
		
		System.out.println(x>10 && x<20);
		
		//char형 변수 ch가 공백이나 탭이 아닐 때 true인 조건식
		char ch1 = ' ';
		
		System.out.println(ch1!=' ' && ch1!='\t');
		
		//char형 변수 ch가 'x' 또는 'X'일 때 true인 조건식
		char ch2 = 'x';
		
		System.out.println(ch2=='x' || ch2=='X');
		
		//char형 변수 ch가 숫자('0'~'9')일 때 true인 조건식
		char ch3 = '0';
		
		System.out.println(ch3>='0' && ch3<='9');
		
		//char형 변수 ch가 영문자(대문자 또는 소문자)일 때 true인 조건식
		char ch4 = 'a';
		
		System.out.println((ch4>='A'&&ch4<='Z')||(ch4>='a'&&ch4<='z'));
		
		//int형 변수 year가 400으로 나워떨어지거나 또는 4로 나눠떨어지고 100으로 나눠떨어지지 않을 때 true인 조건식
		int year = 400;
		
		System.out.println(year%400==0 || (year%4==0 && year%100!=0));
		
		//boolean형 변수 powerOn이 false일 때 true인 조건식
		boolean powerOn = false;
		
		System.out.println(!powerOn);
		
		//문자열 참조변수 str이  "yes"일 때 true인 조건식
		String str = "yes";
		
		System.out.println(str.equals("yes"));
		
		
		

	}

}
