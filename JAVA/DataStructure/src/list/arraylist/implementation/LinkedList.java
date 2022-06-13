package list.arraylist.implementation;

// 메모리의 효율적인 사용을 위해 자료구조를 알아야한다.

// 배열과 다르게 linkedList는 위치가 흩어져 있기 때문에 서로 연결되어 있어야 한다.
// arrayList에서는 엘리먼트라고 했지만, linkedList와 같이 연결된 엘리먼트들은 노드(node, 마디, 교점의 의미) 혹은 버텍스(vertex, 정점, 꼭치점)이라 부른다.

// 리스트는 노드들의 모임이다. 
// 노드는 최소한 두 가지 정보를 알아야한다. 노드의 값, 다음 노드. 
// java 노드 -> 객체에 data field와 link field를 만든다. 보통 데이터 필드에는 value, 링크 필드에는 next 변수를 사용한다.

public class LinkedList {
	
	private Node head;
	private Node tail;
	private int size = 0;
	private class Node{
		private Object data;
		private Node next;
		
		public Node(Object input) {
			this.data = input;
			this.next = null;
		}
		public String toString() {
			return String.valueOf(this.data);
		}
	}
	
	// 시작에 추가
	public void addFirst(Object input) {
		// 노드를 생성합니다.
		Node newNode = new Node(input);
		// 새로운 노드의 다음 노드로 헤드를 지정합니다.
		newNode.next = head;
		// 헤드로 새로운 노드를 지정합니다.
		head = newNode;
		size++;
		if(head.next == null) {
			tail = head;
		}
	}
	
	public void addLast(Object input) {
		Node newNode = new Node(input);
		if(size == 0) {
			addFirst(input);
		}else {
			tail.next = newNode;
			tail = newNode;
			size++;
		}
		
	}
	
	// 중간에 추가
	public Node node(int index) {
		Node x = head;
		for(int i = 0; i < index; i++) {
			x = x.next;
		}
		return x;
	}
	
	// node 메서드를 이용해서 특정 위치에 노드를 추가하는 메서드
	public void add(int k, Object input) {
		// 만약 k가 0이라면 첫번째 노드에 추가하는 것이기 때문에 addFirst를 사용합니다.
		if(k == 0) {
			addFirst(input);
		}else {
			Node temp1 = node(k-1);
			// k번째 노드를 temp2로 지정합니다.
			Node temp2 = temp1.next;
			// 새로운 노드를 생성합니다.
			Node newNode = new Node(input);
			// temp1의 다음 노드로 새로운 노드를 지정합니다.
			newNode.next = temp2;
			size++;
			// 새로운 노드의 다음 노드가 없다면 새로운 노드가 마지막 노드이기 때문에 tail로 지정합니다.
			if(newNode.next == null) {
				tail = newNode;
			}
		}
		
	}
	
	// 출력
	public String toString() {
		// 노드가 없다면 []를 리턴합니다.
		if(head == null) {
			return "[]";
		}
		// 탐색을 시작합니다.
		Node temp = head;
		String str = "[";
		// 다음 노드가 없을 때까지 반복문을 실행합니다.
		// 마지막 노드는 다음 노드가 없기 때문에 아래의 구문은 마지막 노드는 제외됩니다.
		while(temp.next != null) {
			str += temp.data + ",";
			temp = temp.next;
		}
		// 마지막 노드를 출력결과에 포함시킵니다.
		str += temp.data;
		return str + "]";
	}
	
	// 처음 노드 삭제
	public Object removeFirst() {
		// 첫번째 노드를 temp로 지정하고 head의 값을 두번째 노드로 변경합니다.
		Node temp = head;
		head = temp.next;
		// 데이터를 삭제하기 전에 리턴할 값을 임시 변수에 담습니다.
		Object returnData = temp.data;
		temp = null;
		size--;
		return returnData;
	}
	
	// 중간 데이터 삭제
	public Object remove(int k) {
		if(k == 0)
			return removeFirst();
		// k-1번째 노드를 temp의 값으로 지정합니다.
		Node temp = node(k-1);
		// 삭제 노드를 todoDeleted에 기록해둡니다.
		// 삭제 노드를 지금 제거하면 삭제 앞 노드와 삭제 뒤 노드를 연결 할 수 없습니다.
		Node todoDeleted = temp.next;
		// 삭제 앞 노드의 다음 노드로 삭제 뒤 노드를 지정합니다.
		temp.next = temp.next.next;
		// 삭제된 데이터를 리턴하기 위해서 returnData에 데이터를 저장합니다.
		Object returnData = todoDeleted.data;
		if(todoDeleted == tail) {
			tail = temp;
		}
		
		// cur.next를 삭제합니다.
		todoDeleted = null;
		size--;
		return returnData;
	}
	
	// 엘리먼트의 크기
	public int size() {
		return size;
	}
	
	// 엘리먼트 가져오기
	public Object get(int k) {
		Node temp = node(k);
		return temp.data;
	}
	
	// 탐색
	public int indexOf(Object data) {
		// 탐색 대상이 되는 노드를 temp로 지정합니다.
		Node temp = head;
		// 탐색 대상이 몇번째 엘리먼트에 있는지를 의미하는 변수로 index를 사용합니다.
		int index = 0;
		// 탐색 값과 탐색 대상의 값을 비교합니다.
		while(temp.data != data) {
			temp = temp.next;
			index++;
			// temp의 값이 null이라는 것은 더이 상 탐색 대상이 없다는 것.
			if(temp == null) {
				return -1;
			}
		}
		return index;
	}
	
	// 반복
    // ArrayList와 다르게 LinkedList에서 get은 효율적이지 않다.
	
	// 반복자를 생성해서 리턴해줍니다.
	public ListIterator listIterator() {
	    return new ListIterator();
	}
	public class ListIterator{
	    private Node lastReturned;
	    private Node next;
	    private int nextIndex;
	     
	    ListIterator(){
	        next = head;
	        nextIndex = 0;
	    }
	    
	    public Object next() {
	        lastReturned = next;
	        next = next.next;
	        nextIndex++;
	        return lastReturned.data;
	    }
	    
	    //hasNext
	    public boolean hasNext() {
	        return nextIndex < size();
	    }
	    
	    //add
	    public void add(Object input){
	        Node newNode = new Node(input);
	        if(lastReturned == null){
	            head= newNode;
	            newNode.next = next;
	        } else {
	            lastReturned.next = newNode;
	            newNode.next = next;
	        }
	        lastReturned = newNode;
	        nextIndex++;
	        size++;
	    }
	}
	
	
	
	
	
	
	
	

}
