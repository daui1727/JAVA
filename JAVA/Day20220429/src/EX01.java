public class EX01 {

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
		
		if(money < p.price) {System.out.println("잔액이 부족하여 " + p + "을/를 살 수 없습니다.");
		return;  // void인 메서드에서 retrun문을 사용하면 for문에서 break를 사용한 것과 같은 효과가 나타난다.
				// return문 뒤에 코드가 위치하면 에러 발생.
		}	
		money -= p.price;
		
		add(p);
		
		
	}
	
	void add(Product p) {
		if(i >= cart.length) {
			Product[] cart2 = new Product[cart.length*2];
//			System.arraycopy(cart, 0, cart2, 0, cart.length);  //  배열의 복사 194p for문보다 훨씬 나음!
// 배열의 복사 Array.copyOf 방식도 있다.   // (Arrays.copyOf(abc, abc.length)  //  (abc, 3) 앞에서 3개만 가져옴 // 단 배열이 같아야 한다. 이 예제에서는 사용 불가.
			
			for(int j = 0; j < cart.length; j++) {  // 배열의 복사 for문 버젼
				cart2[j] = cart[j];
			}
			cart = cart2;    // 본래 [3]의 인스턴스를 참조하던 cart가 cart2에서 새로 생성된 [*2]인스턴스를 참조하게 된다!!!!!!!
		}
		cart[i++] = p;
	}
	
	void summary() {
		String list = "";  // 예제 5-13 String 배열을 list에 넣어 출력
		int sum = 0;
		
		for(int i = 0; i < cart.length; i++) {
			sum += cart[i].price;
			list += cart[i] + " "; 
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

class Tv extends Product {
	Tv() { super(100); }
	public String toString() { return "Tv"; }  // 이 메서드는 객체를 문자열 형태로 바꿔서 String 형태로 반환하는 것.
	// alt + shift + s --> Generate toString()...
}

class Computer extends Product {
	Computer() { super(200); }
	public String toString() { return "Computer";}
}

class Audio extends Product {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
}



