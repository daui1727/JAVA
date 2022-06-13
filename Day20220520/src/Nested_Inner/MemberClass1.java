package Nested_Inner;


/* Member inner class */

class Outer1{
	private int num = 0;
	
	class Member{
		void add(int n) {num += n;}
		int get() {return num;}
	}
}

public class MemberClass1 {

	public static void main(String[] args) {

		Outer1 out1 = new Outer1();
		Outer1 out2 = new Outer1();
		
		Outer1.Member o1 = out1.new Member();
		Outer1.Member o2 = out2.new Member();
		
		o1.add(5);
		System.out.println(o1.get());
		
		o2.add(10);
		System.out.println(o2.get());
		
	}

}
