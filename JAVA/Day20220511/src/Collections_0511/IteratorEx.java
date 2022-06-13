package Collections_0511;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorEx {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();
		
		list.add("toy");
		list.add("box");
		list.add("robot");
		list.add("toy");
		
		// list, set, map에 따라 코드는 바꿔야하는 불편함 때문에 iterator를 사용한다.
		for(String e:list)
			System.out.print(e + '\t');
		
		
		System.out.println("\n------------------------------");
		// next() >> 다음 값을 반환
		// hasNext() >> 가져올 데이터는 있는지?
		// remove() >> next()호출을 통해서 반환된 인스턴스를 삭제.
		Iterator<String> it = list.iterator();
		
		while(it.hasNext()) {
			String str = it.next();
			if(str.equals("toy")) it.remove();
			System.out.print(str + '\t');
		}
		
		System.out.println("\n------------------------------");
		
		it = list.iterator();
		
		while(it.hasNext()) {
			String str2 = it.next();
			if(str2.equals("toy")) it.remove();
			System.out.print(str2 + '\t');
		}
		
	}

}
