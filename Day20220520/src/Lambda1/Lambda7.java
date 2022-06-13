package Lambda1;

@FunctionalInterface
interface Calculate1<T>{
	T cal(T a, T b);
}

public class Lambda7 {
	public static void main(String[] args) {
		
		Calculate1<Integer> c = (a,b) -> a + b;
		System.out.println(c.cal(10, 10));
		
		Calculate1<Double> c1 = (a,b) -> a*b;
		System.out.println(c1.cal(1.2, 3.2));
		
	}
}
