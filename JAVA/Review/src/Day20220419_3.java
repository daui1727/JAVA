
public class Day20220419_3 {

	public static void main(String[] args) {

		
		// 10. char[] 배열 값을 String 배열로, 배열 값을 2진수로 표현
		
//		char[] hex = {'8','A','F','E'};
//		String[] binary = {"0000", "0001", "0010", "0011"
//							,"0100", "0101", "0110", "0111"
//							,"1000", "1001", "1010", "1011"
//							,"1100", "1101", "1110", "1111"
//							};
//		String result = "";
//		
//		for(int i = 0; i < hex.length; i++) {
//			if(hex[i] >= '0' && hex[i] <= '9') {
//				result += binary[hex[i] - '0'];
//			}else {
//				result += binary[hex[i] - 'A' + 10];  // 'C' - 'A' = 2
//			}
//		} // end for
//		
//		System.out.println("hex : " + new String(hex));
//		System.out.println("binary : " + result);
		
		/*------------------------------------------------------------------*/
		
		// 11. String을 char[]로 변환 / char배열 (char[]) 을 출력
//		String src = "ABCDE";
//		for(int i = 0; i < src.length(); i++) {
//			char ch = src.charAt(i);   // src 의 i번째 문자를 ch에 저장
//			System.out.println("src.charAt(" + i + ") : " + ch);
//		}
		// String을 char[]로 변환
//		char[] chArr = src.toCharArray();
//		
//		// char배열 (char[]) 을 출력
//		System.out.println(chArr);
		
		/*------------------------------------------------------------------*/
		
		// 12.  다차원 배열을 하나씩 표현하고 향상된 for문으로 전체 표현 및 총합 계산
		
//		int[][] score = {
//							{100,100,100},
//							{20,20,20},
//							{30,30,30},
//							{40,40,40}
//						};
//		int sum = 0;
//		for(int i = 0; i < score.length; i++) {
//		for(int j = 0; j < score[i].length; j++) {
//		System.out.printf("score[%d][%d] = %d%n", i, j, score[i][j]);
//		}
//		}
//		
//		System.out.println("--------------------------------------------");
//		for(int[] tmp : score) {
//		int j = 0;
//		for(int i : tmp) {
//		sum += i;
//		System.out.print(tmp[j++] + " ");
//		}
//		System.out.println();
//		}
//		
//		System.out.println("sum = " + sum);
		
		/*------------------------------------------------------------------*/
		
		// 13. 각 과목의 총합과 평균을 표현하는 프로그램

		int[][] score = {
				{100,100,100},
				{20,20,20},
				{30,30,30},
				{40,40,40},
				{50,50,50}
			};
		// 과목별 총점
		int korTotal = 0, engTotal = 0, mathTotal = 0;
		
		System.out.println("번호  국어  영어  수학  총점  평균 ");
		System.out.println("====================================");
		
		for(int i = 0; i < score.length; i++) {
			int sum = 0;   // 개인별 총점
			float avg = 0.0f;  //  개인별 평균
			
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
			System.out.printf("%3d", i+1);
			
			for(int j = 0; j < score[i].length; j++) {
				sum += score[i][j];
				System.out.printf("%5d", score[i][j]);
			}
			
			avg = sum/(float)score[i].length;  // 평균계산
			System.out.printf("%5d %5.1f%n", sum, avg);
		} // end for
		
		System.out.println("===================================");
		System.out.printf("총점 : %3d %4d %4d%n", korTotal, engTotal, mathTotal);
		
	
		
		
		
		
	} // end main

}
