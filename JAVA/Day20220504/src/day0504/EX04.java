package day0504;

public class EX04 {

	public static void main(String[] args) {

		try {
			
			method1();
			
		}catch(Exception e) {
			System.out.println("main 메서드에서 예외가 처리되었습니다.");
			e.printStackTrace();
		}
		
	}

	static void method1() throws Exception{
		throw new Exception();
	}

}
