package Collections_0511;

import java.util.Arrays;

public class ArraySort {

	public static void main(String[] args) {

		Person[] person = new Person[3];
		
		person[0] = new Person("아아아",41);
		person[1] = new Person("으으",14);
		person[2] = new Person("이이이이",29);
		
		Arrays.sort(person);
		
		for(Person p : person) {
			System.out.println(p);
		}
		
		
	}

}

class Person implements Comparable{
	
	private String name;
	private int age;
	
	public Person() {}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "name = " + name + ", age = " + age;
	}

	@Override
	public int compareTo(Object o) {
		Person p =  (Person)o;
		
//		if(this.age > p.age) {return 1;}
//		else if(this.age < p.age) {return -1;}
//		else {return 0;}
		
//		return this.age - p.age;  // 위 세 줄과 동일
		
//		return p.age-this.age;  // 큰 숫자부터 나오게.
		
		return this.name.length() - p.name.length();  // 이름 개수로 정렬
	}
	
	
	
	
}
