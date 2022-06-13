package Collections_0511;

import java.util.*;

public class ArraysEx {

	public static void main(String[] args) {

		
		int[] arr = {0,1,2,3,4};
		int[][] arr2D = {{11,12,13}, {21,22,23}};  // 다차원 배열
		
		System.out.println("arr = " + Arrays.toString(arr));
		System.out.println("arr = " + Arrays.deepToString(arr2D)); // 다차원 배열에는 deepToString을 사용해야한다. 
		
		int[] arr2 = Arrays.copyOf(arr, arr.length);
		int[] arr3 = Arrays.copyOf(arr, 3);
		int[] arr4 = Arrays.copyOf(arr, 7);
		int[] arr5 = Arrays.copyOfRange(arr, 2, 4);
		int[] arr6 = Arrays.copyOfRange(arr, 0, 7);
		
		System.out.println("arr2 = " + Arrays.toString(arr2));
		System.out.println("arr3 = " + Arrays.toString(arr3));
		System.out.println("arr4 = " + Arrays.toString(arr4));
		System.out.println("arr5 = " + Arrays.toString(arr5));
		System.out.println("arr6 = " + Arrays.toString(arr6));
		
		int[] arr7 = new int[5];
		Arrays.fill(arr7, 9);  // arr = [9,9,9,9,9];
		System.out.println("arr7 = " + Arrays.toString(arr7));
		
		Arrays.setAll(arr7, i -> (int)(Math.random()*6)+1);   // 1~7 사이의 값을 무작위로 채워넣는다.
		System.out.println("arr7 = " + Arrays.toString(arr7));
		
		for(int i : arr7) {				// 무작위로 채워진 값에 따라 *를 출력하는 프로그램
			char[] graph = new char[i];
			Arrays.fill(graph, '*');
			System.out.println(new String(graph)+i);
		}
		
		String[][] str2D = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		String[][] str2D2 = new String[][] {{"aaa","bbb"},{"AAA","BBB"}};
		
		char[] chArr = {'A','D','C','B','E'};
		
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));  // 정렬하지 않아서 잘못된 결과가 나옴
		System.out.println("= After sorting =");
		Arrays.sort(chArr);
		System.out.println("chArr = " + Arrays.toString(chArr));
		System.out.println("index of B = " + Arrays.binarySearch(chArr, 'B'));  // 정렬하지 않아서 잘못된 결과가 나옴
		// binarySearch 이진 탐색. 중앙 값과 찾는 값을 비교하여 크기로 다음 값을 찾아 다시 비교하는 식으로 계산.
		
		
		
		
	}

}
