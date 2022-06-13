// 예제 6-21 아직 덜함


public class EX06 {

	public static void main(String[] args) {
		
		MyMath mm = new MyMath();
		System.out.println("mm.add(3,3) 결과 : " + mm.add(3,3));
		System.out.println("mm.add(3L,3) 결과 : " + mm.add(3L,3));
		System.out.println("mm.add(3,3L) 결과 : " + mm.add(3,3L));
		
	}

}

class MyMath {

	int add(int a, int b) {
		System.out.print("int add(int a, int b) - ");
		return a+b;
	}
	
	long add(int a, long b) {
		System.out.print("long add(int a, long b) - ");
		return a+b;
	}
	
	long add(long a, int b) {
		System.out.print("long add(long a, int b) - ");
		return a+b;
	}
	
	long add(long a, long b) {
		System.out.print("long add(long a, long b) - ");
		return a+b;
	}
	
}