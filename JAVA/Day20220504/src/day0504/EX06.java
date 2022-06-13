package day0504;


// 해시코드
import java.util.HashSet;

public class EX06 {

	public static void main(String[] args) {

		HashSet<Num> set = new HashSet<>();
		
		set.add(new Num(100));
		set.add(new Num(200));
		set.add(new Num(300));
		set.add(new Num(100));
		
//		for(Num n : set)
//			System.out.println(n.toString());  // 오버라이딩 전에는 주소값을 출력한다.
		
		for(int i = 0; i < set.size(); i++) {
			System.out.println(set.toString());
		}
	}

}


class Num{
	private int num;
	public Num(int n) {
		num = n;
	}

	@Override
	public int hashCode() {
		System.out.println("hashCode");
		return num % 3;
	}
	
	@Override
	public boolean equals(Object obj) {
		System.out.println("equals");
		return num == ((Num)obj).num;
	}
	
	// n값을 주소값이 아니라 실제 값으로 나타내고 싶어서 오버라이딩.
	@Override
	public String toString() {
		return String.valueOf(num); // 문자를 정수로. integer.parseInt 처럼.
	}
}