import java.util.HashSet;
import java.util.Objects;

public class HashSetEx3 {

	public static void main(String[] args) {

		
		HashSet set = new HashSet();
		
		set.add("abc");
		set.add("abc");
		set.add(new Person("David",10));
		set.add(new Person("David",10));
		
		System.out.println(set);
		
	}

}

class Person{
	String name;
	int age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + ":" + age;
	}
	
	@Override
	public int hashCode() {
		// return (name+age).hashCode();
		return Objects.hash(name, age);
	}
	
	@Override
	public boolean equals(Object obj) {
		// instanceof로 타입변환이 되는지 확인해야하지만 하지 않아도 되서 함. obj instanceof Person
		Person tmp = (Person)obj;
		return this.name == tmp.name && this.age == tmp.age ? true : false;
	}
	
}
