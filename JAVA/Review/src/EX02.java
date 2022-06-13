
public class EX02 {

	public static void main(String[] args) {

//		Point ppp = new Point(10,10);
//		Circle ci = new Circle(ppp,5);
//		
//		System.out.println(ppp.toString());
//		System.out.println(ci.calcArea());
//		
//		Rectangle rec = new Rectangle(ppp, 50, 50);
//		
//		System.out.println(rec.calcArea());
		
		Shape shape = new Circle(new Point(10,10),10);
		System.out.println(shape.calcArea());
		
		shape = new Rectangle(new Point(10,10),10.2,10.4);
		System.out.println(shape.calcArea());
		
	}

}

abstract class Shape {
	   Point p;

	   Shape() {
	      this(new Point(0, 0));
	   }

	   Shape(Point p) {
	      this.p = p;
	   }

	   abstract double calcArea(); // 도형의 면적을 계산해서 반환하는 메서드

	   Point getPosition() {
	      return p;
	   }

	   void setPosition(Point p) {
	      this.p = p;
	   }
	}

class Circle extends Shape{
	double r;

	public Circle() {}
	public Circle(Point p, double r) {
		super(p);
		this.r = r;
	}
	
	@Override
	double calcArea() {
		return Math.PI*r*r;
	}
}

class Rectangle extends Shape{
	double width;
	double height;
	
	boolean isSquare() {
		if(width == height) return true;
		return false;
	}
	
	@Override
	double calcArea() {
		return width*height;
	}
	
	public Rectangle() {}
	public Rectangle(Point p, double w, double h) {
		super(p);
		width = w;
		height = h;
	}
}

class Point {
	   int x;
	   int y;

	   Point() {
	      this(0, 0);
	   }

	   Point(int x, int y) {
	      this.x = x;
	      this.y = y;
	   }

	   public String toString() {
	      return "[" + x + "," + y + "]";
	   }
	}




