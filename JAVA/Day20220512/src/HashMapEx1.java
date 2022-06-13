import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class HashMapEx1 {

	public static void main(String[] args) {

//		HashMap<Integer, String> map = new HashMap<Integer, String>();
		// map은 반복문을 돌릴 수 없어서 key 값만 set으로 집어넣어서 반복문을 사용한다. 둘 다 중복을 허용하지 않음 value는 중복 가능하다
		TreeMap<Integer, String> map = new TreeMap<Integer, String>();  // 이진검색트리의 형태로 키와 값의 쌍으로 된 데이터를 저장한다.
		// 검색과 정렬에 더 적합한 컬렉션 클래스
		
		map.put(3, "kim");
		map.put(4, "hong");
		map.put(4, "lee");
		map.put(4, "lee2");
		map.put(5, "park");
		map.put(6, "kim");
		map.put(13, "kim");
		map.put(20, "kim");
		map.put(6, "kim");
		map.put(4, "kim");
		
		System.out.println(map);
		System.out.println(map.get(5));
		
		Set<Integer> set = map.keySet();
		
		for(Integer n : set) {  // key 출력
			System.out.print(n + "\t");
		}
		
		System.out.println();
		
		for(Integer n : set) {  // value
			System.out.print(map.get(n)+"\t");
		}
		
		System.out.println();
		
		Iterator<Integer> itr = set.iterator();
		while(itr.hasNext())
			System.out.print(map.get(itr.next()) + "\t");
	}

}
