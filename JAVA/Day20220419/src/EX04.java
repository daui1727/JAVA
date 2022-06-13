import java.util.Arrays;

public class EX04 {

	public static void main(String[] args) {

		
//		int[] arr = {10, 20, 30, 40, 50};
//		int sum = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			sum += arr[i];
//		}
//		
//		System.out.println("sum = " + sum);
		
		/* ------------------------------------------------- */
		
//		int[] arr = {10, 20, 30, 40, 50};
//		int sum2 = 0;
//		
//		for(int i : arr) {
//			sum2 += i;
//		}
//		
//		System.out.println("sum = " + sum2);
		
		/* ------------------------------------------------- */

		
//		int[][] arr = {
//							{5,5,5,5,5},
//							{10,10,10,10,10},
//							{20,20,20,20,20,20,20},
//							{30,30,30,30,30,30}
//						};
//		
//		int total = 0;
//		float average = 0;
//		int count = 0;
//		
//		for(int i = 0; i < arr.length; i++) {
//			for(int j = 0; j < arr[i].length; j++) {
//				total += arr[i][j];
//				count++;
//			}
//		}
//		average = total/(float)(count);
//		
//		
//		System.out.println("total = " + total);
//		System.out.printf("average = %.1f" , average);
		
		/* ------------------------------------------------- */
		
		// 다음은 1과 9사이의 중복되지 않은 숫자로 이루어진 3자리 숫자를 만들어내는 프로그램이다.
		// (1) ~ (2) 에 알맞은 코드를 넣어서 프로그램을 완성하라.
		
//		int[] ballArr = {1,2,3,4,5,6,7,8,9};
//		int[] ball3 = new int[3];
//		// 배열 ballArr의 임의의 요소를 골라서 위치를 바꾼다.
//		for(int i = 0; i < ballArr.length; i++) {
//			int j = (int)(Math.random()*ballArr.length);   // 0 ~ 9
//			int tmp = 0;
//			// (1)
//			tmp = ballArr[i];
//			ballArr[i] = ballArr[j];
//			ballArr[j] = tmp;
//		}
//		
//		// 배열 ballArr의 앞에서 3개의 수를 배열 ball3으로 복사한다.
//		// (2)
//		for(int i = 0; i < ball3.length; i++) {
//			ball3[i] = ballArr[i];
//		}
//		
//		for(int i = 0; i < ball3.length; i++) {
//			System.out.println(ball3[i]);
//		}
		
		/* ------------------------------------------------- */
		
		// 다음은 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제이다.
		// 변수 money의 금액을 동전으로 바꾸었을 때 각각 몇 개의 동전이 필요한지 계산해서 출력하라.
		// 단, 가능한 적은 수의 동전으로 거슬러 주어야한다. (1)에 알맞는
		
		// [hint] 나눗셈 연산자와 나머지 연산자를 사용해야한다.....
		
//		int[] coinUnit = {500, 100, 50, 10};
//		int money = 2680;
//		System.out.println("money = " + money);
		
//		for(int i = 0; i < coinUnit.length; i++) {
//			// (1)
//			
//			int num = money / coinUnit[i];
//			money %= coinUnit[i];
//			System.out.println(coinUnit[i] + "원 : " + num + "개");
//			
//			
//		}
		
		
		/* ------------------------------------------------- */
		
		// 배열 answer에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*' *을 찍어서 그래프를 그리는 프로그램이다.
		// (1) ~ (2)에 알맞은 코드를 ~
		
//		int[] answer = {1,4,4,3,1,4,4,2,1,3,2};
//		int[] counter = new int[4];
//		
//		for(int i = 0; i < answer.length; i++) {
//			// (1)
//			counter[answer[i]-1]++;
//		}
//		
//		for(int i = 0; i < counter.length; i++) {
//			// (2)
//			
//			System.out.print(counter[i]);
//			for(int j = 0; j < counter[i]; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		/*
		  출력 결과
		  3***
		  2**
		  2**
		  4****
		 */
		
		
		/* ------------------------------------------------- */
		
		// 주어진 2차원 배열의 데이터보다 가로와 세로로 1이 더 큰 배열을 생성해서
		// 배열의 행과 열의 마지막 요소에 각 열과 행의 총합을 저장하고 출력하는 프로그램이다.

		int[][] score = {
							{100,100,100},
							{20,20,20},
							{30,30,30},
							{40,40,40},
							{50,50,50}
						};
		int[][] result = new int[score.length + 1][score[0].length + 1];
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				result[i][j] = score[i][j];
				
				result[i][result[0].length-1] += score[i][j];
				result[result.length-1][j] += score[i][j];
			}
		}
		
		for(int i = 0; i < result.length; i++) {
			for(int j = 0; j < result[i].length; j++) {
				System.out.printf("%4d", result[i][j]);
			}
			System.out.println();
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
