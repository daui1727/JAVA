
public class EX03 {

	public static void main(String[] args) {

		Singleton s1 = Singleton.getInstance();
		System.out.println(s1);
		
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		
	}

}

final class Singleton{
	private static Singleton s = new Singleton();
	private Singleton() {}
	
	public static Singleton getInstance() {
		if(s == null)
			s = new Singleton();
		return s;
	}
	
}
