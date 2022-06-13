package exList;

import java.util.ArrayList;

public class myList {

	public static void main(String[] args) {
		
		ArrayList<Integer> mylist = new ArrayList<Integer>(); 
		System.out.println(mylist.toString());
		
		// add
		mylist.add(27);
		mylist.add(35);
		mylist.add(11);
		System.out.println(mylist.toString());
		
		mylist.add(0,31);
		System.out.println(mylist.toString());
		
		// remove
		mylist.remove(1);
		System.out.println(mylist.toString());
		
		// get
		System.out.println(mylist.get(0));
		
		// indexOf
		System.out.println(mylist.indexOf(11));   // 2 -> 배열의 2번째 방에 있다고 알려줌.
		
		// size
		System.out.println(mylist.size());
		
		// contains
		System.out.println(mylist.contains(11));  // true -> 배열에 값 11이 있는지 판단
	}

}
// 알고리즘 풀이에 있어 적합한 자료구조를 선택하는 것은 매우 중요하다.
// 보다 효율적으로 데이터를 관리하기 위해.