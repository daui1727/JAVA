import java.util.Arrays;

public class EX02 {

	public static void main(String[] args) {

		
		/*---------------------------------------------------------------*/
		
//		int[] ball = new int[45];
//		int[] arr = new int[10];
//		
//		for(int i = 0; i < ball.length; i++) {
//			ball[i] = i+1;
//		}
//		for(int i = 0; i < arr.length; i++) {
//			int tmp = (int)(Math.random()*ball.length);
//			arr[i] = ball[tmp];
//		}
//		System.out.println(Arrays.toString(arr));
		
		/*---------------------------------------------------------------*/
		
//		int[] numArr = new int[10];
//		
//		for(int i = 0; i < numArr.length; i++) {
//			System.out.print(numArr[i] = (int)(Math.random()*10));
//		}
//		System.out.println();
//		
//		for(int i = 0; i < numArr.length-1; i++) {
//			boolean changed = false;  // 자리바꿈이 발생했는지를 체크한다.
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
//			if(!changed) break;   // changed != true
//			
//			for(int k = 0; k < numArr.length; k++) {
//				System.out.print(numArr[k]);
//			}
//			System.out.println();
//		} // end for i
		
		/*---------------------------------------------------------------*/
		
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
		
		/*---------------------------------------------------------------*/
		
		// 기본형 --> int, double >> 기본형 변수 공간안에는 값이 저장됨.    
		// 참조형 --> String >> 참조형 변수 공간에는 주소값이 저장됨.
		
//		String[] name = new String[3]; // [null,null,null]
//		int[] age = new int[3];  // [0,0,0]
//		name[0] = "kor";
//		
//		System.out.println(Arrays.toString(age));
//		System.out.println(Arrays.toString(name));
//		
//		String[] name2 = new String[] {"kim","gim","lee"};
//		System.out.println(Arrays.toString(name2));
		
		
		/*---------------------------------------------------------------*/
		
		
		String[] names = {"Kim", "Park", "Yi"};
		
		for(int i = 0; i < names.length; i++) {
			System.out.println("names[" + i + "] : " + names[i]);
		}
		String tmp = names[2];
		System.out.println("tmp : " + tmp);
		names[0] = "Yu";
		
		/*  // 아래의 향상된 for문과 같은 문장.
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
		*/
		
		for(String str : names) {  // 향상된 for문
			System.out.println(str);
		}
		
		
		
		
		
		
		
		
	}

}
