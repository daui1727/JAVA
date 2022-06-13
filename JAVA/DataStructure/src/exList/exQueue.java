package exList;

import java.util.LinkedList;
import java.util.Queue;

public class exQueue {

	public static void main(String[] args) {

		// 큐 --> 선입선출의 개념. LinkedList의 인터페이스 형태로 구현되어 있으며, 가변성이 뛰어나며, 자료를 넣고 빼는데 속도가 무척 빠르다.
		
		Queue<Integer> myQ = new LinkedList<Integer>();
		System.out.println(myQ);
		
		myQ.add(15);
		myQ.add(12);
		myQ.add(43);
		myQ.add(11);
		System.out.println(myQ.toString());
		
		// peek
		System.out.println(myQ.peek());   // 가장 앞에 있는 값, 즉 다음에 나올 값을 확인하는 메서드. 단순히 호출만 하기에 값은 그대로.
		
		// poll
		System.out.println(myQ.poll());    //  15  호출과 동시에 제거하게 된다.
		System.out.println(myQ.toString());   // [12,43,11]
		
		// size
		System.out.println(myQ.size());
		
		// clear
		myQ.clear(); // 큐의 값을 비운다는 뜻으로, 큐 자체가 사라지지는 않는다.
		
		System.out.println(myQ.isEmpty());   // true  큐가 모두 비었는지 확인하는 메서드로 주로 while과 함께 사용되며, BFS 등 알고리즘 구현에 자주 사용된다.
	}

}
