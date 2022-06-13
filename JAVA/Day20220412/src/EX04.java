
public class EX04 {

	public static void main(String[] args) {

		
		
		System.out.println("main() 함수!!");
		
		int result =  sub(5,10);  // 함수 호출  -->  인자값
		
		System.out.println("결과 값은 " + result);
			
	}
	
	public static int sub(int i, int j) {
		
		int num = i*j;
		
		System.out.println("sub() 함수...");
		
		return num;
	}

}
