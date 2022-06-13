package AnonymousClass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AnonymousClass3 {

	public static void main(String[] args) {

		List<String> list = new ArrayList<String>();
		
		list.add("robot");
		list.add("apple");
		list.add("toy");
		
		
		Comparator<String> cmp = new Comparator<String>() {      // Anonymous2를 익명클래스로 변경하는 법 
			
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		};
		
		Collections.sort(list,cmp);  //  sort 조건을 준다.
		System.out.println(list);
		
	}

}
