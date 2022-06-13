package pack0428;

public class EX04 {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		
		b.summary();
	}

}

class Buyer{
	int money = 1000;
	
	Product[] cart = new Product[3];   // 구입한 제품을 저장하기 위한 배열.
	int i = 0;						   // Product배열 cart에 사용될 index
	
	void buy(Product p) {
		
		if(money < p.price) {System.out.println("잔액이 부족하여" + p + "을/를 살 수 없습니다.");}	
		money -= p.price;
		
		add(p);
		
		
	}
	
	void add(Product p) {
		if(i >= cart.length) {
			Product[] cart2 = new Product[cart.length*2];
			System.arraycopy(cart, 0, cart2, 0, cart.length);
		}
		cart[i++] = p;
	}
	
	void summary() {
		String list = "";
		int sum = 0;
		
		for(int i = 0; i < cart.length; i++) {
			sum += cart[i].price;
			list += cart[i];
		}
		
		System.out.println("물건 목록 : " + list);
		System.out.println("총 가격 : " + sum);
		System.out.println("남은 가격 : " + money);
	}
}

class Product{
	int price;
	Product(int price){
		this.price = price;
	}
}

class Tv extends Product{
	Tv(){super(100);}
	public String toString() {return "Tv";}
}

class Computer extends Product{
	Computer(){super(200);}
	public String toString() {return "Computer";}
}

class Audio extends Product{
	Audio(){super(50);}
	public String toString() {return "Audio";}
}


