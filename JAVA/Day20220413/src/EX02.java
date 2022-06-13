import java.util.Arrays;

public class EX02 {

	public static void main(String[] args) {

		// 교재 5-1
		int[] score = new int[5];
		int k = 1;
		
		score[0] = 50;
		score[1] = 60;
		score[k+1] = 70;   // score[2] = 70;
		score[3] = 80;
		score[4] = 90;
		
		int tmp = score[k+2] + score[4];  // int tmp = score[3] + score[4];
		
		// for문으로 배열의 모든 요소를 출력한다.
		for(int i = 0; i < score.length; i++) {
			System.out.printf("score[%d] : %d%n", i, score[i]);
		}
		
		System.out.printf("tmp : %d%n", tmp);
//		System.out.printf("score[%d] : %d%n", 7, score[7]);  // index의 범위를 벗어난 값.
		
		System.out.println();
		
//		//  교재 5-2
//		int[] iArr1 = new int[10];
//		int[] iArr2 = new int[10];
////		int[] iArr3 = new int[] {100, 95, 80, 70, 60};
//		int[] iArr3 = {100, 95, 80, 70, 60};
//		char[] chArr = {'a', 'b', 'c', 'd'};
//		
//		for (int i = 0; i < iArr1.length; i++) {
//			iArr1[i] = i + 1;  // 1 ~ 10 의 숫자를 순서대로 배열에 넣는다.
//		}
//		
//		for (int i = 0; i < iArr2.length; i++) {
//			iArr2[i] = (int)(Math.random()*10) + 1;  // 1 ~ 10의 값을 배열에 저장.
//		}
//		
//		// 배열에 저장된 값들을 출력한다.
//		for (int i = 0; i < iArr1.length; i++) {
//			System.out.print(iArr1[i] + ",");
//		}
//		System.out.println();
//		System.out.println(Arrays.toString(iArr2));
//		System.out.println(Arrays.toString(iArr3));
//		System.out.println(Arrays.toString(chArr));
//		System.out.println(iArr3);  // 해당 주소값이 출력된다.
//		System.out.println(chArr);
		
		/* ----------------------------------------------------------------------------- */
//		
//		int[] iArr1 = new int[5];
//	
//		int[] tmp2 = new int[iArr1.length * 2];   // iArr1 방이 5칸에서 10칸으로 확장 공사
//		
//		for (int i = 0; i < iArr1.length; i++) {
//			iArr1[i] = (int)(Math.random()*10) + 1;  // 1 ~ 10의 값을 배열에 저장.
//		}
//
//		System.out.println(Arrays.toString(iArr1));
//		
//		for (int i = 0; i < iArr1.length; i++) {
//			tmp2[i] = iArr1[i];
//		}
//		iArr1 = tmp2;  // 방 확장
//		
//		System.out.println(Arrays.toString(iArr1));
		
		
		/* ----------------------------------------------------------------------------- */
		
		double[] iArr1 = new double[10];
		double[] tmp3 = new double[iArr1.length * 2];
		
		for(int i = 0; i < iArr1.length; i++) {
			iArr1[i] = (double)(Math.random()*10) + 1;
		}
		System.out.println(Arrays.toString(iArr1));
		
		for(int i = 0; i < iArr1.length; i++) {
			tmp3[i] = iArr1[i];
		}
		iArr1 = tmp3;

		for(int i = 0; i < iArr1.length; i++)
			System.out.printf("%.2f\n", iArr1[i]);
	
		
	}

}
