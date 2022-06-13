
public class EX09 {

	public static void main(String[] args) {
		
		int n1,n2;
		n1 = 10;
		n2 = 20;
		
		System.out.println("before" + n1 + " ," + n2);
		
		swap(n1, n2);  // 두 수 교환
		
		System.out.println("after" + n1 + " ," +n2);
	}		
	
	// 입력(o), 출력(x)  -->  두 수를 교환
	public static void swap(int n1, int n2) {
		
		int tmp;
		tmp = n1;
		n1 = n2;
		n2 = tmp;
		System.out.println("swap : " + n1 + " ," + n2);
		
		// 다른 값이기 때문에 n 값은 변하지 않는다.
		
	}				


}
