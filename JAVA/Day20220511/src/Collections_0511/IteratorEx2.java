package Collections_0511;

import java.util.*;

public class IteratorEx2 {

	public static void main(String[] args) {

		
		ArrayList original = new ArrayList(10);
		ArrayList copy1 = new ArrayList(10);
		ArrayList copy2 = new ArrayList(10);
		
		for(int i = 0; i < 10; i++) {
			original.add(i+"");
		} // end for
		
		Iterator it = original.iterator();
		while(it.hasNext()) {
			copy1.add(it.next());
		} // end while
		
		System.out.println("= Original에서 copy1로 복사(copy) =");
		System.out.println("original:" + original);
		System.out.println("copy1:" + copy1);
		System.out.println();
									// 위 코드에서 iterator는 0~9에서 마지막인 9에 해당하는 상태기 때문에 다시
									// 받아오지 않는다면 원하는 결과가 나오지 않는다. 따라서.
		it = original.iterator();  //Iterator는 재사용이 안되므로, 다시 얻어와야한다.
		while(it.hasNext()) {
			copy2.add(it.next());
			it.remove();
		} // end while
		
		
		System.out.println("= Original에서 copy2로 이동(move) =");
		System.out.println("original:" + original);
		System.out.println("copy2:" + copy2);
		
		
	}

}
