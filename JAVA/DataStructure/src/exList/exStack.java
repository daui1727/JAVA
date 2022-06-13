package exList;

import java.util.Stack;

public class exStack {

	public static void main(String[] args) {

		// 스택 -> 후입선출의 개념으로 마지막으로 넣었던 값이 가장 먼저 뽑히는 구조.
		
		Stack<Integer> myStack = new Stack<Integer>();
		System.out.println(myStack.toString());
		
		// add, push   // 둘 다 값을 넣을 때 사용하고 새로 넣은 값이 가장 마지막에 위치한다.
		myStack.add(15);
		myStack.push(12);
		myStack.add(43);
		myStack.add(11);
		System.out.println(myStack.toString());
		
		// peek
		System.out.println(myStack.peek());
		System.out.println(myStack.toString());
		
		// pop
		System.out.println(myStack.pop());      //  11   -->  큐의 poll과 같다.
		System.out.println(myStack.toString());   // [15,12,43]
		
		// size, clear, isEmpty
		
		
	}

}
