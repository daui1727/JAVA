package Collections_0511;

import java.util.*;

public class ComparableEx {

	public static void main(String[] args) {

		
		List<Point> point = new ArrayList<Point>();
		
		point.add(new Point(10,20));
		point.add(new Point(50,10));
		point.add(new Point(30,30));
		
		MySort sort = new MySort();
		Collections.sort(point, sort);  // 정렬대상 정렬기준
		
		for(Point p : point)
			System.out.println(p);
		
		
	}

}

class Point implements Comparator<Point>{
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Point [x =" + x + ", y = " + y + "]";
	}

	@Override
	public int compare(Point o1, Point o2) {
		return o1.y - o2.y;
	}
	
}

class MySort implements Comparator<Point>{
	@Override
	public int compare(Point o1, Point o2) {
		return o1.y - o2.y;
	}
}




