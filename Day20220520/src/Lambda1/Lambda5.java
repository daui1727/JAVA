package Lambda1;

interface Calculate{ int cal(int n1, int n2);}

class Caltor implements Calculate{
	@Override
	public int cal(int n1, int n2) {
		return n1+n2;
	}
}

public class Lambda5 {
	public static void main(String[] args) {
		
		Calculate c = (int n1, int n2) -> {
			return n1 + n2;
		};
		System.out.println( c.cal(5, 2) );

		
		c = (n1,n2) -> {return n1+n2;};
		System.out.println(c.cal(5, 9));
		
		
		c = (n1,n2) -> n1 + n2;
		System.out.println(c.cal(5, 9));
		
		c = (n1,n2) -> n1 * n2;
		System.out.println(c.cal(5, 9));
		
		/* */
		
		c = new jam();
		System.out.println(c.cal(4, 5));
	}
}

class jam implements Calculate{
	@Override
	public int cal(int n1, int n2) {
		return n1*n2;
	}
}
