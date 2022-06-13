package thread0518;

public class CurrentThreadName {

	public static void main(String[] args) {
		
		Thread ct = Thread.currentThread();
		String name = ct.getName();
		
		System.out.println(name);

	}

}
