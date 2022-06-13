
public class TestVariables {

	public static void main(String[] args) {

		
		Variables var = new Variables();
		
		var.iv++;
	//	var.cv++;
		Variables.cv++;  // 클래스 변수  // 위의 방법으로는 나중에 구분이 쉽지 않기때문에 이 방식을 쓴다.
		
		System.out.println(var.iv);
		System.out.println(var.cv);
		
		Variables var2 = new Variables();
		var2.iv++;
		Variables.cv++;
		System.out.println(var2.iv);
		System.out.println(var2.cv);
		
		Variables var3 = new Variables();
		var3.iv++;
		Variables.cv++;
		System.out.println(var3.iv);
		System.out.println(var3.cv);
		
		System.out.println("----------------------");
		
		Variables var4 = new Variables();
		System.out.println(var4.iv);
		
	}

}

class Variables{
	int iv;         // 인스턴스변수, 멤버변수
	static int cv;  // 클래스 변수, 정적변수, 공유변수
	
	void method() {
		int iv = 0;    // 지역변수
	}
}
