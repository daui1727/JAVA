// 객체지향프로그래밍1 파트까지 완료
public class EX07 {

	public static void main(String[] args) {
				
		Car2 c1 = new Car2();
		Car2 c2 = new Car2();
		Car2 c3 = new Car2();
		c1.num++;
		
		System.out.println(c1.num);
		System.out.println(c2.num);
		System.out.println(c3.num);
		
		Car3 c10 = Car3.getInstance();  // 객체 생성 전에 메서드 영역에 접근해서 가져옴
		System.out.println(c10.num);
		c10.num++;
		System.out.println(c10.num);
		
		Car3 c11 = Car3.getInstance();  // 객체 생성 전에 메서드 영역에 접근해서 가져옴
		c11.num++;
		System.out.println(c11.num);
		c11.num++;		
		System.out.println(c10.num);
	}

}

class Car2{
	int num = 10;
	
	public Car2() {
		
	}
}

class Car3{
	private static Car3 car3 = null;
	
	int num = 10000;
	
	private Car3() {}
	
	public static Car3 getInstance() {
		if(car3 == null)
			car3 = new Car3();  // 생성자 호출
		return car3;
	}
	
}