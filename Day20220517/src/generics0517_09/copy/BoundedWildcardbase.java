package generics0517_09.copy;

class Box<T>{
	protected T ob;
	public T getOb() {return ob;}
	public void setOb(T ob) {this.ob = ob;}
	
	@Override
	public String toString() {
		return ob.toString();
	}
}

class Toy{
	@Override
	public String toString() {
		return "I am Toy";
	}
}

//public static void outBox(Box<? extends Toy> box)
class Robot extends Toy{}

class BoxHandler{										// box 전달 대상은 Toy, Robot 가능
	public static void outBox(Box<? extends Toy> box) {  // box에는 전달 가능 인스턴스는 Toy 또는 Toy 상속한 아이들
		Toy t = box.getOb();
		System.out.println(t);
//		box.setOb(t); // 에러. setOb에 로봇이 들어갈 수도 있기때문에 에러.
	}
	
	public static void inBox(Box<? super Toy> box, Toy t) { // extends는 get만 가능 // super 는 set만 가능
		box.setOb(t);
		
//		Toy t2 = box.getOb();
//		System.out.println(t2);
	}
}


public class BoundedWildcardbase {

	public static void main(String[] args) {

		Box<Toy> box = new Box<>();
		BoxHandler.inBox(box, new Toy());
		BoxHandler.outBox(box);
	
	}

}

