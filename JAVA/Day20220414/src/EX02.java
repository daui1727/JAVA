import java.util.Arrays;

public class EX02 {

	public static void main(String[] args) {

		// int 배열 1 ~ 100 사이 값을 랜덤하게 입력받아서 총합과 평균 구하기
		int sum = 0;
		double avg = 0;
		
		int[] nArr = new int[10];
		
		for(int i = 0; i < 10; i++) {
			nArr[i] = (int)(Math.random()*100)+1;
		}
		
		// 총합 구하기
		for(int i = 0; i < 10; i++)
			sum += nArr[i];
		
		// 총합과 평균 출력하기
		System.out.println(Arrays.toString(nArr));
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + (double)sum/nArr.length);
		

	}

}
