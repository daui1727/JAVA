import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		
//		int sum = 0;
//		int i = 1;
//		
//		for (; i<6;) {   // 초기화 값은 7번 줄처럼 미리 써두고 생략 가능하다.  // 증감식 또한 마찬가지. 단 위치를 주의해야한다.
//			// sum += i++;    이런 식으로도 가능.
//			sum += i;
//			System.out.println("i : " + i + ", sum = " + sum);
//			i++;
//		}
//		
//		System.out.println("Last sum = " + sum);
		
		
		/* ------------------------------------------------------------------------------------------ */
		
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요. --> ");
		
		int user, com;
		
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		
		user = Integer.parseInt(tmp);
		com = (int)(Math.random()*3) + 1;
		
		System.out.println("당신은 " + user + "입니다");
		System.out.println("컴은 " + com + "입니다");
		
		if(user-com == 2 || user-com == -1) {
			System.out.println("당신이 졌습니다.");
		} else if(user-com == 1 || user-com ==-2) {
			System.out.println("당신이 이겼습니다.");
		} else {
			System.out.println("비겼습니다.");
		} // if문의 끝
		
		
		
		
		

	} // main의 끝

}
