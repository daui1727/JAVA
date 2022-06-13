import java.util.Arrays;

public class EX02 {

	public static void main(String[] args) {
		Shape s = new Circle();
		Shape s2 = new Circle(new Point(10,10), 5);
		Shape s3 = new Circle(5);
		
		Shape r = new Rectangle();
		Shape r2 = new Rectangle(150,10);
		Shape r3 = new Rectangle(new Point(100,100), 150, 50);
		
		System.out.println(s2.calcArea());
		System.out.println(s3.calcArea());
		
		System.out.println(r3.calcArea());

		
		
	}

}

abstract class Shape{  // 추상클래스
	Point p;
	
	Shape(){
		this(new Point(0,0));
	}
	
	Shape(Point p){
		this.p = p;
	}
	
	abstract double calcArea();   // 도형의 면적을 계산해서 반환하는 메서드  // 추상메서드 반드시 오버라이드
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p){
		this.p = p;
	}
	
}

/*------------------------------------------------------------------------------*/
//Circle
class Circle extends Shape{
	double r;

	public Circle() {}
	public Circle(double r) {  // Shape s3 = new Circle(5); 이거 받음
//		super(new Point(0,0));
		this.r = r;
	}
	public Circle(Point p, double r) {  //Shape s2 = new Circle(new Point(10,10), 10); 이걸 받아줌
		super(p);
		this.r = r;
	}
	
	@Override
	double calcArea() {
		return Math.PI*r*r;
	}
	
}

//Rectangle
class Rectangle extends Shape{
	double width, height;
	
	public Rectangle() {
		this(new Point(0,0),0,0);   // 하나의 통로로 이동되게 하는것이 좋다
	}
	public Rectangle(double width, double height) {  //Shape r2 = new Rectangle(150,10); 이거 받음
//		this.width = width;
//		this.height = height;
		this(new Point(0,0),width,height);  // 하나의 통로로 이동되게 하는것이 좋다
	}
	
	public Rectangle(Point p, double width, double height) {  //Shape r3 = new Rectangle(new Point(100,100), 150, 50);
		super(p);
		this.width = width;
		this.height = height;
	}

	boolean isSquare() {
		if(width == height && width != 0 && height != 0) {  // width == height && width*height != 0 으로 축약 가능
			System.out.println("정사각형");
			return true;
		}else
			return false;
	}
	
	@Override
	double calcArea() {
		return width*height;
	}
}

/*------------------------------------------------------------------------------*/

class Point{
	int x, y;
	
	Point(){
		this(0,0);
	}
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "[" + x + "," + y + "]"; 
	}
	
}