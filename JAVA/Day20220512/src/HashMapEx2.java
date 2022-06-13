import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class HashMapEx2 {

	public static void main(String[] args) {

		TreeMap<Integer, String> map = new TreeMap<Integer, String>(new AgeDesc()); 
		
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
	}

}

class AgeDesc implements Comparator<Integer>{
	
	@Override
	public int compare(Integer o1, Integer o2) {
		return o2 -o1;
	}
	
	
	
	
	
	
	
}
