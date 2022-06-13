package Nested_Inner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

interface Printable{ void print(); }

class Papers{
	private String con;
	public Papers(String s) {con = s;}
	
	
	public Printable getPrinter() {return new Printer();}  // 어떤 객체를 생성하는지 Printer2()를 생성한다면 칼라 출력.
	
	private class Printer implements Printable{
		
		public void print() {System.out.println("흑백 : " + con);}  // 인터페이스 속 메서드와 같은 이름이여야한다.
		
	}
	
	private class Printer2 implements Printable{
		
		public void print() {System.out.println("칼라 : " + con);}  // 인터페이스 속 메서드와 같은 이름이여야한다.
		
	}
}


public class UsememberEx1 {

	public static void main(String[] args) {
		
		Papers p = new Papers("message java!!");
		Printable prn = p.getPrinter(); // 10번째 줄에 접근해서 객체를 생성.  // getPrinter는 그저 객체 생성할 뿐 위에서 컨트롤.
		prn.print();
		
		
		List<String> list = new ArrayList<>();
		list.add("aaaa");
		list.add("bbbb");
		list.add("cccc");
		
		Iterator<String> it = list.iterator();
		while(it.hasNext()) {System.out.println(it.next() + " ");}

	}

}
