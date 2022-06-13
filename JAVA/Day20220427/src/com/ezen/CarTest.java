package com.ezen;

import lombok.Getter;
import lombok.Setter;

public class CarTest {

	public static void main(String[] args) {

		Sedan se = new Sedan();  // Car의 요소를 가진 Sedan 클래스를 se가 참조하고있다.
		se.setColor("red");
		System.out.println(se.getColor());
		
		se.setPassenger(4);
		System.out.println(se.getPassenger() + "명");
		
		/*--------------------------------------------------*/
		
		Sedan se2 = new Sedan("blue", 2, 4, 3);
		System.out.println(se2.getPassenger());
		System.out.println(se2.getColor());
		
		/*--------------------------------------------------*/
		
		Sports sp = new Sports();
		sp.setColor("Redddd");
		System.out.println(sp.getColor());
		se2.run();
		
		Sports sp2 = new Sports("yellow", 2, 4, 1, 5000);
		System.out.println(sp2.getColor() + " " + sp2.horsepower);
		
		sp2.run();
		
	}

}
@Getter
@Setter
class Car{
	private int passenger, tire, seat;
	
	public Car() {}
	public Car(int passenger, int tire, int seat) {
		System.out.println("Car()생성자");
		this.passenger = passenger;
		this.tire = tire;
		this.seat = seat;
	}
	
	void run() {
		System.out.println("달리다.");
	}
	void stop() {}
}

@Getter
@Setter
class Sedan extends Car{
	private String color;
	void gas() {}
	
	public Sedan() {}
	public Sedan(String color, int passenger, int tire, int seat) {
		super(passenger, tire, seat);  // super는 맨 첫줄에 있어야한다.
		System.out.println("Sedan()생성자");
		this.color = color;
//		setPassenger(passenger);  // super대신 setter 방식으로도 가능하다
//		setTire(tire);
//		setSeat(seat);
	}
}

class Sports extends Sedan{
	int horsepower;
	
	public Sports() {}
	public Sports(String color, int passenger, int tire, int seat, int horsepower) {
		super(color, passenger, tire, seat);
		this.horsepower = horsepower;
	}
	
	void run() {
		System.out.println("스포츠 카가 달리다.");
	}
}






class Bus extends Car{
	int passengerCount;
	void passsengerLoad() {}
}

class Truck extends Car{
	int load;
	void ObjectLoad() {}	
}