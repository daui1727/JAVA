package Lambda1;

import java.util.Random;


interface Cenerator{ int rand(); }

public class Lambda6 {
	public static void main(String[] args) {
		
		Cenerator gen = () -> {
			Random rand = new Random();
			return rand.nextInt(50);  // 0 ~ 49
		};
		
		int num = gen.rand();
		System.out.println(num);
		
	}
}
