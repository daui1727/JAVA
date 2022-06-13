package Collections_0511;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("toy","box","robot","box");
		System.out.println(list);  // 단순히 위 코드처럼 초기화하고 출력하는건 가능하지만   
//		list.add("box");    // 추가의 경우엔 오류가 난다.
		
		list = new ArrayList<String>(list);   // 때문에 list를 다시 처리하여 사용해야한다.
		
		ListIterator<String> it = list.listIterator();  // 양방향 조회 기능 추가
		while(it.hasNext()) {  // 순방향으로 진행하면서 읽어온다.
			String str = it.next();
			System.out.print(str+"\t");
		}
		
		System.out.println();
		
		while(it.hasPrevious()) {  // 역방향으로 읽어온다.
			String str = it.previous();
			System.out.print(str + "\t");
		}
		
		System.out.println();
		System.out.println();
		
		for(Iterator<String> itr = list.iterator(); itr.hasNext();)  // 19번째 줄 아래의 코드들과 동일.
			System.out.print(itr.next() + "\t");
	
		// iterator는 collection인터페이스에 정의된 메서드이므로 collection을 상속받는 list나 set은 iterator를
		// 바로 사용할 수 있지만 map의 경우는 상속받지 않기 때문에 set으로 변경 후 다시 처리하는 방식으로 사용한다.  
		// ex) Iterator it = map.entrySet().iterator();
		
		
		
	}

}
