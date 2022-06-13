package package0429;

// 추상클래스
public class EX01 {

	public static void main(String[] args) {

		Product pro = new Computer();
		System.out.println(pro.price);
		pro.test();
		pro.func();
	}

}


/*-----------------------------------------------------------------------------------------------------*/

abstract class Product{   // 추상클래스
	int price;
	Product(int price){
		this.price = price;
	}
	void test() {
		System.out.println("Product");
	}
	
	abstract void func();  // 추상메서드 // 이 경우엔 아래에 상속받던 자식 클래스에 오류가 생긴다. --> 자식클래스에서 고쳐서 써라는 뜻.
}

class Tv extends Product {
	Tv() { super(100); }
	public String toString() { return "Tv"; }  // 이 메서드는 객체를 문자열 형태로 바꿔서 String 형태로 반환하는 것.
	// alt + shift + s --> Generate toString()...
	@Override
	void func() {
		System.out.println("tv");
	}
}

class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer";}
	@Override
	void func() {
		System.out.println("com");
	}
}

class Audio extends Product {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
	@Override
	void func() {
		System.out.println("audio");
	}
}