package Lambda;


// 1을 익명 클래스로.

interface Printable2{void print(String s);}

public class Lambda2 {

	public static void main(String[] args) {
		
		Printable2 prn = new Printable2() {
			public void print(String s) {
				System.out.println(s);
			}
		};
		
		prn.print("java is lambda2!");

	}

}
