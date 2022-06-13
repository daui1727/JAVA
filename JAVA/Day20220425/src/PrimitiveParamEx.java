class Data {int x;}

class PrimitiveParamEx {

	public static void main(String[] args) {

		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x = " + d.x);
		
		change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
		
	}
	
	static void change(int x) {   // 기본형 매개변수
		x = 1000;
		System.out.println("change() :  x = " + x);
	}

}



// 인스턴스 변수와 메서드는 객체가 생성되야 사용 가능하다.
// 인스턴스 변수 및 메서드는 사용 가능 대상이 인스턴스변수 인스턴스메서드와 클래스 변수, 클래스 메서드 등 접근 가능하다.
// 클래스 변수와 클래스메서드는 객체 생성 전에 method area 영역에 생성된다. 따라서 클래스변수 메서드는 생성되지 않은
// 인스턴스 변수 인스턴스 메서드에는 접근이 불가하다.
