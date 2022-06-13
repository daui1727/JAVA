
public class EX01 {

	public static void main(String[] args) {

		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		c1.num++;
		System.out.println(c1.num);
		System.out.println(c2.num);
		System.out.println(c3.num);
		
		c1.func();
		
		Car2 c10 = Car2.getInstance();
		c10.num++;
		System.out.println("c10 : " + c10.num);
		
		Car2 c11 = Car2.getInstance();
		c11.num++;
		System.out.println("c11 : " + c11.num);
		
	}

}

class Car{
	int num = 10;
	public Car() {
		System.out.println("car 생성자");
	}
	void func() {
		System.out.println("func");
	}
}

class Car2{  // 디자인 패턴  --> 싱글톤
	
//	private static Car2 car2 = null;
//	int num = 100;
//	private Car2() {}
//	
//	public static Car2 getInstance() {
//		if(car2 == null)
//			car2 = new Car2();  // 생성자 호출
//		return car2;
//	}
	
	private static Car2 car2 = new Car2();
	   
	   int num=100;
	   
	   private Car2() {}
	   
	   public static Car2 getInstance() {
	      return car2;
	   }
	
}
// 1. 일반적으로 객체 생성 시 생성자를 통해서 객체를 생성한다.
// 2. 싱글톤은 생성자 private >> 외부접근 금지.
// 3. 어떻게 접근할 것인가?? --> getInstance메서드에서 객체를 생성하고있다.
// 4. 외부에서 객체를 생성하려면 getInstance를 통해서만 가능하다.
// 5. getInstance도 메서드이기 때문에 외부에서 접근하려면 객체를 생성하고 접근해야한다.
// 6. static 메서드는 객체를 생성하지 않고서도 접근 가능하다. 따라서 getInstance를 static 메서드로 변경한다.
// 7. getInstance static 메서드에서 객체를 생성해서 참조변수 car2에게 생성된 객체 주소값을 넘겨준다.
// 8. Car2 car2를 설정하려면 --? >> static변수(클래스 변수로 설정)로 ~
