// 추상메서드

public class EX02 {

	public static void main(String[] args) {

		
		AA a = new CC();
		System.out.println(a.a);
		a.test();
		a.func();
	}

}

abstract class AA{  // 추상클래스
	int a = 10;
	void test() {
		System.out.println("aaa");
	}
	abstract void func();  // 추상메서드
	abstract void func1();
	abstract void func2();
	abstract void func3();
	abstract void func4();
}

abstract class BB extends AA{
	void func() {
		System.out.println("bbb");
	}
}

class CC extends BB{

	@Override
	void func1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void func2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void func3() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void func4() {
		// TODO Auto-generated method stub
		
	}
	
}