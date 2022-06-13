import java.util.ArrayList;

public class FruitBoxEx1 {

	public static void main(String[] args) {

		Box3<Fruit> fruitBox = new Box3<Fruit>();
		Box3<AApple> appleBox = new Box3<AApple>();
		Box3<Toy> toyBox = new Box3<Toy>();
		// Box3<Grape> grapeBox = new Box<Apple>();  에러 타입 불일치
		
		fruitBox.add(new Fruit());
		fruitBox.add(new AApple());  // Ok,  void add(Fruit item)
		
		appleBox.add(new AApple());
		appleBox.add(new AApple());
		// appleBox.add(new Toy());  에러 Box<AApple>에는 AApple만 담을 수 있음.
		
		toyBox.add(new Toy());
		
		System.out.println(fruitBox);
		System.out.println(appleBox);
		System.out.println(toyBox);
		
		
	} // main의 끝

}

class Box3<T>{
	ArrayList<T> list = new ArrayList<T>();
	void add(T item) {list.add(item);}
	T get(int i) {return list.get(i);}
	int size() {return list.size();}
	public String toString() {
		return list.toString();
	}
}

class Fruit{
	public String toString() {
		return "Fruit";
	}
}

class AApple extends Fruit{
	public String toString() {
		return "AApple";
	}
}

class Grape extends Fruit{
	public String toString() {
		return "Grape";
	}
}

class Toy{
	public String toString() {
		return "Toy";
	}
}
