package pack0428;

public class EX01 {

	public static void main(String[] args) {
//		animal an1 = new animal();
//		animal an2 = new Mammal();
//		animal an3 = new Person();
//		
//		an1.eat();
//		an2.eat();
//		an3.eat();
//		
//		an3.eat(new animal());
//		
//		Mammal ma = new Person();
//		ma.eat();
//		
////		Whale wh = new Person();  // 오류
////		wh.eat();
//		
//		Object obj = new Person();  // 이렇게 생성은 가능. 하지만 사용은 힘듬
////		obj.eat();  // 오류
//		Person p2 = (Person)obj;
//		p2.eat();
//		
//		Person p = (Person)an3;
//		p.eat();
//		p.run();
//		
//		Mammal m1 = (Mammal)an3;
//		m1.eat();
		
		animal animal = new Person();
		
//		Person person = (Person)animal;  // 사용할때 오류가 난다.
		if(animal instanceof Birds) {
			Birds birds =  (Birds)animal;
			birds.eat();
		}
		else if(animal instanceof Mammal) {
			Mammal mammal = (Mammal)animal;
			mammal.run();
		}
		
		
	}

}

class animal{  // 동물
	void eat() {
		System.out.println("동물이 먹는다");
	}

	public void eat(animal animal) {
		System.out.println("으아아아아아아아아아아아아악");
	}
}
class Mammal extends animal{  // 포유류
	void eat() {
		System.out.println("포유류가 먹는다");
	}
	void run() {
		System.out.println("포유류가 달린다");
	}
}
class Whale extends Mammal{  // 고래
	void eat() {
		System.out.println("고래가 먹는다");
	}
}
class Person extends Mammal{  // 사람
	void eat() {
		System.out.println("사람이 먹는다");
	}
}

class Birds extends animal{  // 조류
	void eat() {
		System.out.println("조류가 먹는다");
	}
}
class Penguin extends Birds{
	void eat() {
		System.out.println("펭귄이 먹는다");
	}
	void play() {
		System.out.println("펭귄이 논다");
	}
}
class Sparrow extends Birds{
	void eat() {
		System.out.println("참새가 먹는다");
	}
}