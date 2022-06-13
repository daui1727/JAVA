package Collections0510;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx1 {

	public static void main(String[] args) {

		ArrayList list1 = new ArrayList(10);
		list1.add(5); //  이렇게도 가능
		list1.add(new Integer(4));  // wrapper?
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		print(list1,list2);
		
		Collections.sort(list1);   // list1과 list2를 정렬한다.
		Collections.sort(list2);   // Collections.sort(List 1)를 이용하여 정렬.
		print(list1, list2);
		
		// list1이 list2의 모든 요소를 포함하고 있을 때만 true
		System.out.println("list1.containsAll(list2) : " + list1.containsAll(list2));
		
		list2.add("B");
		list2.add("C");	
		list2.add("A");
		print(list1, list2);
		
		list2.set(3,"AA");
		print(list1, list2);
		
		// list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제한다.
		System.out.println("list1.retainAll(list2) : " + list1.retainAll(list2));
		print(list1, list2);

		// list2에서 list1에 포함된 객체들을 삭제한다.
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		
		print(list1, list2);
		
	}

	private static void print(ArrayList list1, ArrayList list2) {
		
		System.out.println("list1 : " + list1);
		System.out.println("list2 : " + list2);
		System.out.println();
		
	}

}
