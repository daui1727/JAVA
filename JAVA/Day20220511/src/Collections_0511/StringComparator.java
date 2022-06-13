package Collections_0511;

import java.util.*;

public class StringComparator {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		
		list.add("robot");
		list.add("Apple");
		list.add("box");
		list.add("Car");
		
		StrSort sort = new StrSort();
		
		Collections.sort(list);
		for(String s : list)
			System.out.println(s);
		
	}

}

class StrSort implements Comparator<String>{  // 내 정렬 방식을 따로 지정해줘야한다.
	@Override
	public int compare(String o1, String o2) {
		return o1.compareToIgnoreCase(o2);
	}
}
