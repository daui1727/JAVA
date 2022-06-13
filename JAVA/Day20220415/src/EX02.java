import java.util.Scanner;

public class EX02 {

	public static void main(String[] args) {

		// if문을 사용하여 다섯 개 정수를 입력받아서 가장 큰 수를 출력하는 프로그램 작성
		
		// 입력받는 숫자는 0 ~ 100  사이 값만 5개 입력받아서 큰 수 구하기
		
		Scanner sc = new Scanner(System.in);
		int num, max = 0, i = 0;
		String tmp;
		
		System.out.println("정수 5회 입력 : ");
//		for(int i = 0; i < 5; i++) {
//			tmp = sc.nextLine();
//			num = Integer.parseInt(tmp);
//			if(num < 0 || num>100) {
//				--i;
//				continue;
//			}
//			if(max < num) max = num;
//		}
		
		while(i<5) {
			tmp = sc.nextLine();
			num = Integer.parseInt(tmp);
			if(num>0 && num<101) {
				if(max < num) max = num;
				i++;
			} else {
				System.out.println("0 이상 100이하만 입력가능");
			}
		}
		
		System.out.println("최대값 : " + max);
		
		
		
	}

}
