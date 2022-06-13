import java.util.*;

// set 인터페이스는 중복을 허용하지 않고, 저장순서가 유지되지 않는 컬렉션 클래스를 구현하는데 사용된다.

public class HashSetEx01 {

	public static void main(String[] args) {
		
		Set<Num> set = new HashSet<Num>();  // Hashset을 Num과 같은 클래스로만 제어하려면
											// hashCode()와 equals()를 적절히 오버라이딩해야한다.
		
		set.add(new Num(5));
		set.add(new Num(1));
		set.add(new Num(3));
		set.add(new Num(2));
		set.add(new Num(5));
		
		System.out.println("count : " + set.size());
		
		for(Iterator<Num> itr = set.iterator(); itr.hasNext();){
			System.out.print(itr.next() + "\t");
		}
		System.out.println();
		
		for(Num s : set){
			System.out.print(s + "\t");
		}
		
		/*---------------------------------*/
		Set<Car> set2 = new HashSet<Car>();
		
		set2.add(new Car("Y201","red", 100));
		set2.add(new Car("Y202","black", 200));
		set2.add(new Car("Y201","red", 100));
		set2.add(new Car("Y201","white", 200));
		set2.add(new Car("Y203","black", 500));

		System.out.println("count : " + set2.size());
		
		for(Iterator<Car> itr = set2.iterator(); itr.hasNext();){
			System.out.print(itr.next() + "\t");
		}
		System.out.println();
		
		for(Car s : set2){
			System.out.print(s + "\t");
		}
		
	}

}

class Num{
	private int num;
	public Num(int num) {this.num = num;}
	
	@Override
	public String toString() {
		return String.valueOf(num);   // 정수를 문자로 바꿔주는
	}
	
	@Override
	public int hashCode() {
		return num % 3;  // 3개의 방을 생성해서 add에 들어간 숫자의 나머지를 해당 방에 배정.
						// set.add(new Num(5));의 경우 나머지가 2기 때문에 2번 방.
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this.num == ((Num)obj).num)
			return true;
		else
			return false;
	}
	
}

class Car{
	private String model;
	private String color;
	private int price;
	
	public Car(String model, String color, int p) {
		this.model = model;
		this.color = color;
		price = p;  // 이렇게 접근하는 방식은 좋지는 않다.
	}
	
	@Override
	public String toString() {
		return model + "-" + color + "-" + price + ",";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(model, color, price);
	}
	
	@Override
	public boolean equals(Object obj) {
		String m = ((Car)obj).model;
		String c = ((Car)obj).color;
		int p = ((Car)obj).price;
		
//		if(model.equals(m) && color.equals(c)) return true;
//		else return false;
		
		return model.equals(m) && color.equals(c) && price == p ? true : false;
		
	}
	
}


