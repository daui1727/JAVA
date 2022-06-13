import java.util.Scanner;

public class EX01 {

	public static void main(String[] args) {
		
		
//		for(int i=1; i<=3; i++) {
//			for(int j=1; j<=3; j++) {
//				for(int k=1; k<=3; k++) {
//					System.out.println(""+i+j+k);
//				}
//			}
//		}
		
		/*------------------------------------------------------------------*/
		
//		for(int i=1; i<=5; i++) {
//			for(int j=1; j<=5; j++) {
//				if(i==j) {
//					System.out.printf("[%d,%d]",i,j);
//				} else {
//					System.out.printf("%5c",' ');
//				}
//			}
//			System.out.println();
//		}
		
		/*------------------------------------------------------------------*/
		
//		int [] arr = {10,20,30,40,50};
//		
////		for(int i=0; i<arr.length; i++) {
////			System.out.println(arr[i]);
////		}
		
		/*------------------------------------------------------------------*/
//		
//		int sum = 0;
//		
//		for(int i=0; i<arr.length; i++)
//			System.out.printf("%d ",arr[i]);
//		System.out.println();
//		
//		for(int tmp:arr) {
//			System.out.printf("%d ",tmp);
//			sum += tmp;
//		}
//		System.out.println();
//		System.out.println("sum = " +sum);
		
		
//		int i = 5;
//		while(--i!=0) {
//			System.out.println(i + " - I can do it.");
//		}
		
		/*------------------------------------------------------------------*/
		
		int num = 0, sum = 0;
		System.out.print("숫자를 입력하세요.(예:12345)--> ");
		
		Scanner sc = new Scanner(System.in);
		String tmp = sc.nextLine();
		num = Integer.parseInt(tmp);
		
		while(num!=0) {
			sum += num%10;
			System.out.printf("sum=%3d num=%d%n",sum,num);
			
			num/=10;
		}
		System.out.println("각 자리수의 합: " +sum);
		
		// 12345 $ 10  --> 5  나머지를 구하는방법
		// 12345 / 10  --> 1234 

		
		
		
		
		
	} // main의 끝

}
