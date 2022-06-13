import lombok.ToString;

public class EX03{}

class CarTest {

	public static void main(String[] args) {

		
		Sedan se = new Sedan("white", 5, 4);
		se.color = "white";
		se.passenger = 5;
		se.tire = 4;
		
		System.out.println(se.color + " " + se.passenger + " " + se.tire);
		se.run();
		Bus bu = new Bus();
		bu.passenger = 15;
		bu.tire = 6;
		System.out.println(bu.passenger + " " + bu.tire);
		
		Sports ss = new Sports("RED",2,4,2,1000);
		System.out.println(ss.color + " " + ss.passenger + " " + ss.tire + " " + ss.seat + " " + ss.sports);
	}

}
class Car3{
	int passenger;
	int tire;
	int seat;
	
	/*------------------------------------------------------------------------*/
	
	public Car3() {}
	public Car3(int passenger, int tire, int seat) { // Sedan의 super를 받아주는 부분
		this.passenger = passenger;
		this.tire = tire;
		this.seat = seat;
		System.out.println("Car3() 생성자");
	}
	
	/*------------------------------------------------------------------------*/
	
	void run() {
		System.out.println("run()");
	}
	void stop() {}
}

/*------------------------------------------------------------------------*/

class Sedan extends Car3{
	String color;
	
	public Sedan() {}
	public Sedan(String color, int passenger, int tire) {
		super(passenger, tire, 0);   // 상위 클래스 생성자 호출
		this.color = color;
//		this.passenger = passenger;
//		this.tire = tire;
		System.out.println("Sedan() 생성자");
	}
	
	public Sedan(String color, int passenger, int tire, int seat) {
		super(passenger, tire, seat);
		this.color = color;
	}
}

class Bus extends Car3{
	void passengerLoad() {}
}

class Truck extends Car3{
	void objectLoad() {}
}

/*------------------------------------------------------------------------*/

class Sports extends Sedan{
	
	int sports;
	
	public Sports() {}
	public Sports(String color, int passenger, int tire, int seat, int sports) {
		super(color, passenger, tire, seat);
		this.sports = sports;
	}

	
	
}



