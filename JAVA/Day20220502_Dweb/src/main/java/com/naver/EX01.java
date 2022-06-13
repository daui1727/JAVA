package com.naver;

public class EX01 {

	public static void main(String[] args) {
		
		// 다형성 예제?
		
		Book b = new Novel("메타버스 소설", "출판사(IT)");
		b.print();
		Book c = new SF("메타버스 소설", "출판사");
		c.print();
		
	}

}
class Book{
	public String name;
	public String publisher;
	
	Book(){
		this.name="";
		this.publisher="";
	}
	Book(String name, String publisher){
		this.name = name;
		this.publisher = publisher;
	}
	void print() {
		System.out.println("print: Book");
	}
}

class Novel extends Book{
	public String name;
	public String publisher;
	Novel(){}
	Novel(String name, String publisher){
		super(name, publisher);
	}
	
	@Override
	void print() {
		System.out.println("print: Novel");
	}
}

class SF extends Book{
	public String name;
	public String publisher;
	SF(){}
	SF(String name, String publisher){
		super(name, publisher);
	}
	
	@Override
	void print() {
		System.out.println("print: SF");
	}
	
	
}








