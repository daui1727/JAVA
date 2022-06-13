import java.util.Arrays;

public class EX04 {

	public static void main(String[] args) {

		
		// 정수형 배열 5개 선언
		// 초기화는 랜덤함수 통해서 1 ~ 100 사이 값을 저장 및 출력
		
		int[] num = new int[5];
		
		for(int i = 0; i < num.length; i++) {
			num[i] = (int)(Math.random()*100)+1;
		}
		
		System.out.println(Arrays.toString(num));
		
		
		// 최대값 및 최소값 계산 및 출력
		
		int max = num[0];
		int min = num[0];
		
		for(int i = 0; i < num.length; i++) {
			
			if(max < num[i])
				max = num[i];
			
			// 최소값
			if(min > num[i])
				min = num[i];
		}
		
		System.out.println("max : " + max);
		System.out.println("min : " + min);
		
		// Sort(정렬)

		for (int i = 0; i < num.length; i++) {
			
			for(int j = 0; j < num.length; j++) {
				if(num[i] > num[j])
					num[i] = num[j];
				
				for (int k = 0; k < num.length; k++) {
					
				}
			}
			
		}
		System.out.println(Arrays.toString(num));
	}

}
