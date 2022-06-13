package LocalClass;

interface Printable{ void print(); }

class Papers{
	private String con;
	public Papers(String s) {con = s;}
	
	
	public Printable getPrinter() {
		
		//  local class
		class Printer implements Printable{
			public void print() {
				System.out.println(con);
			}
		}
		
		return new Printer();  // 반환하면서 객체 생성. prn이 받는다.
		
	}
}

public class LocalClass1 {

	public static void main(String[] args) {

		Papers p = new Papers("message java!!");
		Printable prn = p.getPrinter();
		prn.print();
		
	}

}
