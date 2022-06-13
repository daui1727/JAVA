import java.util.Arrays;

public class EX00 {

	public static void main(String[] args) {

		
		int[] score = new int[5];  // 5개의 int 값을 저장할 수 있는 배열을 생성한다.
		score[2] = 100; // 배열의 3번째 요소에 100을 저장.
		int value = score[3]; // 배열 4번째 요소에 있는 값을 value에 저장.
		
		for(int i = 0; i < 5; i++)
			score[i] = i*10;
		
		System.out.println(Arrays.toString(score));
		
		System.out.println();
		
		
		
	}

}
