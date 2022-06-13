
public class EX01 {

	public static void main(String[] args) {

		// 배열의 활용
		
//		int sum = 0;
//		float average = 0f;
//		
//		int[] score = {100, 88, 100, 100, 90};
//		
//		for(int i = 0; i < score.length; i++) {
//			sum += score[i];
//		}
//		
//		average = sum / (float)score.length;  // 계산 결과를 float로 얻기 위해서 형변환
//		
//		System.out.println("총점 : "+ sum);
//		System.out.println("평균 : "+ average);
	
		/*---------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------*/
		
//		int[] score = {79, 88, 91, 33, 100, 55, 95};
//		
//		int max = score[0];
//		int min = score[0];
//		
//		for(int i = 1; i < score.length; i ++) {
//			if(score[i] > max) {
//				max = score[i];
//			} else if(score[i] < min) {
//				min = score[i];
//			}
//		} // end for
//		
//		System.out.println("최대값 : " + max);
//		System.out.println("최소값 : " + min);
		
		/*---------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------*/
		
//		int[] numArr = new int[45];
//		
//		for(int i = 0; i < numArr.length; i++) {
//			numArr[i] = i+1;  // 1 ~ 45까지의 숫자를 채워넣는다.
//			System.out.print(numArr[i]);
//		}
//		System.out.println();
//		
//		for(int i = 0; i < 100; i++) {
//			int n = (int)(Math.random() * 45); // 주소값 0 ~ 44
//			
//			int tmp = numArr[0];
//			numArr[0] = numArr[n];
//			numArr[n] = tmp;
//		}
//		System.out.println();
//		
//		for(int i = 0; i < 6; i++) {
//			System.out.print(numArr[i] + ",");
//		}
		
		/*---------------------------------------------------------------------------*/
		/*---------------------------------------------------------------------------*/
		
		int[] ball = new int[45];
		
		for(int i = 0; i < ball.length; i++) {   // 배열 속 값은 1 ~ 45
			ball[i] = i+1;
		}
		
		int temp = 0;
		int j = 0;  // 임의의 값을 얻어 저장할 변수
		
		for(int i = 0; i < 6; i++) {
			j = (int)(Math.random()*45);  // 0 ~ 44 범위의 값을 얻는다.  // 배열은 0 ~ 44
			temp = ball[i];
			ball[i] = ball[j];
			ball[j] = temp;
		}
		
		for(int i = 0; i < 6; i++) {
			System.out.printf("ball[%d] = %d%n", i, ball[i]);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
