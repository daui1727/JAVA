import java.util.Arrays;

public class Day20220419_2 {

	public static void main(String[] args) {

		
		// 5. 하나의 배열 속 값을 다른 배열 속에 랜덤하게 넣기.
		
//		int[] ball = new int[45];
//		int[] arr = new int[10];
//		
//		for(int i = 0; i < ball.length; i++) {  // 1 ~ 45의 값을 배열 속에 넣음
//			ball[i] = i+1;
//		}
//		for(int i = 0; i < arr.length; i++) {
//			int tmp = (int)(Math.random()*ball.length); // tmp에 45개의 랜덤한 값을 넣고
//			arr[i] = ball[tmp];                         // ball배열에서 랜덤한 숫자를 arr배열에 넣는다.
//		}
//		System.out.println(Arrays.toString(arr));
		
		/* ------------------------------------------------------------------------ */
		
		// 6. 하나의 배열에 랜덤한 숫자를 넣고 낮은 값 순서대로 정렬하기.
		
//		int[] numArr = new int[10];
//		
//		for(int i = 0; i < numArr.length; i++) {
//			System.out.print(numArr[i] = (int)(Math.random()*10)); // 0~9까지의 숫자 넣고 출력
//		}
//		System.out.println();
//		
//		for(int i = 0; i < numArr.length-1; i++) {
//			boolean changed = false;  // 자리바꿈이 발생했는지를 체크.
//			
//			for(int j = 0; j < numArr.length-1-i; j++) {
//				if(numArr[j] > numArr[j+1]) {
//					int temp = numArr[j];
//					numArr[j] = numArr[j+1];
//					numArr[j+1] = temp;
//					
//					changed = true;
//				}
//			} // end for j
//			if(!changed) break;
//			
//			for(int k = 0; k < numArr.length; k++) {
//				System.out.print(numArr[k]);
//			}
//			System.out.println();
//		} // end for i
		
		/* ------------------------------------------------------------------------ */
		
		// 7. 하나의 배열에 0 ~ 9까지의 숫자를 랜덤하게 넣고 그 수를 카운트하는 프로그램
		
//		int[] numArr = new int[10];
//		int[] counter = new int[10];
//		
//		for(int i = 0; i < numArr.length; i++) {
//			numArr[i] = (int)(Math.random()*10);
//			System.out.print(numArr[i]);
//		}
//		System.out.println();
//		
//		for(int i = 0; i < numArr.length; i++) {
//			counter[numArr[i]]++;  // numArr[0]의 값이 3이라면 counter[3]의 값을 0(현재값)에서 1로 올려라라는 뜻.
//		}
//		for(int i = 0; i < numArr.length; i++) {
//			System.out.println(i + "의 개수" + counter[i]);
//		}
		
		/* ------------------------------------------------------------------------ */
		
		// 8.  String 문자열 배열 표현
		
//		String[] name = new String[3];
//		int[] age = new int[3];
//		name[0] = "kor";
//		System.out.println(Arrays.toString(age));
//		System.out.println(Arrays.toString(name));
//		
//		String[] name2 = new String[] {"kim","gim","lee"};
//		System.out.println(Arrays.toString(name2));
		
		/* ------------------------------------------------------------------------ */
		
		// 9.  향상된 for문 사용.
		
		String[] names = {"kim", "park", "yi"};
		for(int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "] : " + names[i]);
		}
		
		String tmp = names[2];
		System.out.println("tmp : " + tmp);
		names[0] = "Yu";
		
		/*  // 아래와 같은 문장
		 for(int i = 0; i < names.length; i++){
			System.out.println(names[i]);		 	
		 }
		 */
		
		for(String str : names) {
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // end main

}
