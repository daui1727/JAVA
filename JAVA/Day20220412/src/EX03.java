
public class EX03 {

	public static void main(String[] args) {

		
		// 3) 함수에서 입력(X), 출력(O)의 경우
		double dnum = 2;
		int num2 = 5;
		
		System.out.println("main() 함수!!");
		
//		int result = sub();    // sub 호출 시 int num = 10000이 반환되어 result 값이 받아준다.
		double result = sub();    // sub 호출 시 int num = 10000이 반환되어 result 값이 받아준다.
		
		System.out.println("결과 값은 "+ result);
		
		
	}
	
	
	// void 자리에는 반환형이 온다 --> void는 반환값이 없다는 것을 명시.
	// sub는 함수 이름. --> 변수 이름 중에서 명명한다.
	public static double sub() {
		
//		int num = 10000;
		double dnum = 12.5;
		
		System.out.println("sub() 함수...");
		
//		return num;
		return dnum;
	}

}
