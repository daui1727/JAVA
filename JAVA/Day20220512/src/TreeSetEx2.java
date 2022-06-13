import java.util.Iterator;
import java.util.TreeSet;

public class TreeSetEx2 {

	public static void main(String[] args) {

		TreeSet<Person3> tree = new TreeSet<>();
		
		tree.add(new Person3("kim",20));
		tree.add(new Person3("park",50));
		tree.add(new Person3("Lee",80));
		tree.add(new Person3("Lee",80));  // 미완성 예제. 출력되야할게 아직 안된 이유는 hashcode와 equals를 오버라이딩하지 않았기 때문
		tree.add(new Person3("kim",29));
		tree.add(new Person3("kim",80));
		
		for(Person3 n : tree) {
			System.out.println(n);
		}
		
		
	}

}

class Person3 implements Comparable<Person3>{  // 컴퓨터는 알아서 값을 비교하지 못하기 때문에 Comparable을 구현하여 오름차순으로 
	String name;
	int age;
	
	public Person3(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return name + " : " + age;
	}
	
    @Override
    public int compareTo(Person3 o) {
    	return this.age - o.age;
    }
	
}
