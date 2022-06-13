
public class EX08 {

	public static void main(String[] args) {
		
		boolean flag = gugudan();
				
		if(flag == true)
			System.out.println("출력 성공");
		else
			System.out.println("출력 실패");
		
		}
			
	// 입력(x), 출력(ㅇ)
		public static boolean gugudan() {
				
				
			boolean flag = true;
			int n = 3;
				
			System.out.println("입력한 " + n + "단 출력");
			for(int i = 1; i <= 9; i++)
				System.out.println(n*i);
			
			return flag;
		}


}
