public class EX01 {

	public static void main(String[] args) {

		// 버스의 기본 요금은 1500 이라고 가정
		// 나이는 랜덤함수으로 입력
		/*
		   0 ~ 3세   할인율 100%
		   4 ~ 13세  할인율  50%
		   14 ~ 19세 할인율  25%
		   20세 이상  할인율   0%
		   65세 이상  할인율  100%
		 */
		// 버스 요금 계산 문제
		
//		int bus = 1500;
//		
//		int	age = (int)(Math.random()*100)+1;
		
//		if(age >= 0 && age <= 3) {
//			bus -= (bus*1);
//		}
//		else if(age >= 4 && age <= 13) {
//			bus -= (bus*0.5);
//		}
//		else if(age >= 14 && age <= 19) {
//			bus -= (bus*0.25);
//		}
//		else if(age >= 20 && age < 65) {
//			bus -= (bus*0);
//		}
//		else if(age >= 65) {
//			bus -= (bus*1);
//		}
		
//		if(age >= 65)
//			bus -= (bus*1);
//		else if(age >= 20)
//			bus -= (bus*0);
//		else if(age >= 14 && age <= 19)
//			bus -= (bus*0.25);
//		else if(age >= 4 && age <= 13)
//			bus -= (bus*0.5);
//		else if(age >= 0 && age <= 3)
//			bus -= (bus*1);
		
//		System.out.println(age + "세의 버스 요금은 " + bus);
		
		
		/* -- */
		
		
		int age = (int)(Math.random()*100)+1;
		int fee = 1500;
		double rate = 0;
		
		if(age>=65)
			rate = 0.0;
		else if(age >= 20)
			rate = 1.0;
		else if(age >= 14)
			rate = 0.75;
		else if(age >= 4)
			rate = 0.5;
		else
			rate = 0.0;
		
		System.out.println(age + " : " + "최종요금 : " + (int)(fee*rate) + "원");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
