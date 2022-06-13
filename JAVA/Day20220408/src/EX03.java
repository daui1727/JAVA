
public class EX03 {

	public static void main(String[] args) {

		
		
		// 1+(-2)+3+(-4)+.... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는 지 구하라.
//		
//		int sum = 0;
//		int i = 0;
//		int sign = 1;
//		int tmp = 0;
//		
//		for(i=1; true; i++, sign = -sign) {    //sign 1, -1, 1, -1 ....
//			
//			tmp = i*sign;
//			sum += tmp;
//			
//			if(sum>=100) {
//				break;
//			}
//		}
//		System.out.println("i : " + i + " tmp : " + tmp + " sum : " + sum);
		
		/*----------------------------------------------------------------------------------------*/
		
//		int value = 0;
		
//		for (int i = 0; i<6; ++i)
//			System.out.println((int)(Math.random()*45)+1);
		
		/*----------------------------------------------------------------------------------------*/
		
//		for(int i=0; i<5; i++) {  // 행, 줄
//			for(int j=0; j<=5; j++) {  // 열. 칸
//				System.out.print("*");
//			}
//			System.out.println();  // 줄 바꿈
//		}
		
		
		/*----------------------------------------------------------------------------------------*/
		
		
		for(int i=2; i<10; i++) {
			
			for(int j=1; j<10; j++) {
				System.out.print(i + " x " + j + " = " + i*j + "\t");
			}
			System.out.println();
		}
		
		
		
		
		
		
		

	}

}
