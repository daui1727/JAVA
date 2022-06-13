import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class HashSetLotto {

	public static void main(String[] args) {

		Set set = new HashSet();
		
		for(int i = 0; set.size() < 6; i ++) {  // i가 쓰이고 있진 않다. (; set.size() < 6; )으로 변경 가능
			int num = (int)(Math.random()*45)+1;
			set.add(new Integer(num));  // set.add(num); 으로 입력해도 가능하다.
		}
		
		List list = new LinkedList(set);  // LinkedList(Collection c)
		Collections.sort(list);			// Collections.sort(List list)
		System.out.println(list);
		
	}

}
