import java.util.Arrays;

public class EX01 {

	public static void main(String[] args) {

		
		// 할인율 예제 다시 한번 더.
		
//		int fee = 2500;
//		
//		int age = (int)(Math.random()*100)+1;
//		
//		if(age >= 65) {
//			fee *= 0;
//		} else if (age >= 20) {
//			fee *= 1;
//		} else if (age >= 14) {
//			fee *= 0.75;
//		} else if (age >= 4) {
//			fee *= 0.5;
//		} else {
//			fee *= 0;
//		}
//		
//		System.out.println(age);
//		System.out.println(fee);
		
		/*--------------------------------------------------------------------*/
		
		// 1 ~ 100까지 총합 / 평균 구하기
		// 1 ~ 100까지 2의 배수이면서 7의 배수 구하기 갯수 출력 및 총합
		
//		int sum  = 0; 
//		float avg = 0;
//		
//		for(int i = 1; i <= 100; i++) {
//			sum += i;
//		}
//		avg = sum / 100f;
//		System.out.println(sum);
//		System.out.println(avg);
//		
//		int tmp = 0;
//		int count = 0;
//		
//		for(int i = 1; i <= 100; i++) {
//			if(i%14 == 0) {
//				count++;
//				tmp += i;
//				System.out.print(i + " ");
//			}
//		}		
//		System.out.println("\n총합 : " + tmp);
//		System.out.println("count : " + count);
		
		/*--------------------------------------------------------------------*/
		
		
//		int sum = 0;
//		int count = 0;
//		for(int i = 1; i <= 100; i++) {
//			
//			if(i%2 == 0 && i%7 == 0) {
//				count++;
//				sum += i;
//				System.out.print(i + " ");
//			}
//			
//		}
//		System.out.println();
//		System.out.println(sum);
//		System.out.println(count);
//		
//		int[] tmp = new int[count];
//		int j = 0;
//		for(int i = 1; i <= 100; i++) {
//			if(i%14 == 0) {
//				tmp[j++] = i;
//			}
//		}
//		
//		System.out.println(Arrays.toString(tmp));
		
		/*--------------------------------------------------------------------*/
		
		
//		int[] nArr = {30,20,50,40,10};
//		
//		for(int i = 0; i < nArr.length; i++) {
//			for(int j = 0; j < nArr.length-1; j++) {
//				if(nArr[j] > nArr[j+1]) {
//					int tmp = nArr[j];
//					nArr[j] = nArr[j+1];
//					nArr[j+1] = tmp;
//				}
//			}
//		}
//		
//		System.out.println(Arrays.toString(nArr));
		
		/*--------------------------------------------------------------------*/
		
		// 배열 값 중 가장 앞자리와 최소값을 교체하여 정렬하는 프로그램
		
		int[] nArr = {9,6,7,3,5};
		
		for(int i = 0; i < nArr.length-1; i++) {
			
			int index = i;
			
			for(int j = i + 1; j < nArr.length; j++) {
				
				if(nArr[index] > nArr[j]) index = j;  // 최소값이 나온다.
				
			} // end for j
			
			if(index != i) {
				int tmp = nArr[index];
				nArr[index] = nArr[i];
				nArr[i] = tmp;
			}
			System.out.println(i + 1 +"회전" + Arrays.toString(nArr));
			
		}
		
		System.out.println(Arrays.toString(nArr));
		
		
		
		
		
		
		
		
		
		
		
	} // end main

}
