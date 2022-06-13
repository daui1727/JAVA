package day0504;
// 예외 고의 발생 예제

import java.util.Scanner;

class ReadEX02 extends Exception{   // 예외처리 시는 꼭 상속받아야한다. Exception은 최고 조상클래스기 때문에
	public ReadEX02() {
		super("유효하지 않은 나이가 입력됐습니다.");
	}
	
}

public class EX02 {

	public static void main(String[] args) {

		System.out.print("나이 입력 : ");
		
		try {
			int age = readAge();
			System.out.println("입력된 나이 : " + age);
		}catch(ReadEX02 e){
			System.out.println(e.getMessage());
		}
		
	}

	private static int readAge() throws ReadEX02 {
		Scanner sc = new Scanner(System.in);
		
		int age = sc.nextInt();
		
		if(age < 0)
			throw new ReadEX02();
		
		return age;
	}

}
