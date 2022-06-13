package LGSamsung;

public class TvUser {

	public static void main(String[] args) {
		
		// 여기가 메인.
		// 공통의 기능을 가진 인터페이스 tv를 만들어 LgTv와 SamsungTv가 implements하게 하고
		// 메인에서 사용할때 간단한 코드 변경으로 양쪽 tv를 모두 쓸 수 있다.
		
		// SamsungLG 패키지는 인터페이스하지 않아서 코드를 전부 변경해야만 다른 tv를 사용할 수 있다는
		// 불편함이 있다.
		
//		TV tv = new LgTv();
//		TV tv = new SamsungTv();  // 이런 식으로 변경. 아래 메서드는 공통.
//		
//		tv.PowerOn();
//		tv.PowerDown();
//		tv.volumeUp();
//		tv.volumeDown();
		
		// BeanFactory 적용
		BeanFactory factory = new BeanFactory();
		TV tv = (TV)factory.getBean(args[1]);
		
		tv.PowerOn();
		tv.PowerDown();
		tv.volumeUp();
		tv.volumeDown();
	}

}
