
public class EX07 {

	public static void main(String[] args) {

		int input = 3;
		
		boolean flag = gugudan(input);
				
		if(flag == true)
			System.out.println("출력 성공");
		else
			System.out.println("출력 실패");
		
		}
			
	// 입력(ㅇ), 출력(ㅇ)
		public static boolean gugudan(int n) {
				
				
			boolean flag = true;
				
			System.out.println("입력한 " + n + "단 출력");
			for(int i = 1; i <= 9; i++)
				System.out.println(n*i);
			
			return flag;
		}


}
