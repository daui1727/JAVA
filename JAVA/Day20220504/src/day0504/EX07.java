package day0504;

// 해시코드 - toString

//import java.util.Date;   // 이 코드가 있다면 37번째 줄은 Date today = new Date(); 로 표현 가능하다.

class Card{
	String kind;
	int number;
	
	Card(){
		this("SPADE", 1);
	}
	
	Card(String kind, int number){
		this.kind = kind;
		this.number = number;
	}
	
	@Override
	public String toString() {
		return "kind : " + kind + ", number : " + number;
	}
}

public class EX07 {

	public static void main(String[] args) {

		
		Card c1 = new Card("red",10);
		Card c2 = new Card();
		
		System.out.println(c1);
		System.out.println(c2.toString());
		
		java.util.Date today = new java.util.Date();
		System.out.println(today);
		
	}  // toString()메서드는 메서드 없이 그냥 객체 자체로 자동으로 호출된다. c1처럼. 

}