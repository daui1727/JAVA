package list.arraylist.implementation;

public class Main {
 
    public static void main(String[] args) {
         
    	
    	LinkedList numbers = new LinkedList();
    	numbers.addLast(10);
    	numbers.addLast(20);
    	numbers.addLast(30);
    	numbers.addLast(40);
    	numbers.addLast(50);
    	
    	System.out.println(numbers.removeFirst());
    	System.out.println(numbers.remove(2));
    	System.out.println(numbers.size());
    	System.out.println(numbers.get(1));
    	System.out.println(numbers.indexOf(20));
    	System.out.println(numbers);
    	
    	LinkedList.ListIterator li = numbers.listIterator();
    	
    	while(li.hasNext()){
    		if((int)li.next() == 20)
    	        li.add(60);
//    	    System.out.println(li.next());
    	}
    	System.out.println(numbers);
    	
    	
//        ArrayList numbers = new ArrayList();
//        numbers.addLast(10);
//        numbers.addLast(20);
//        numbers.addLast(30);
//        numbers.addLast(40);
//        numbers.add(1, 15);
//        numbers.addFirst(5);
//        numbers.remove(2);
//        System.out.println(numbers.get(0));
//        System.out.println(numbers.size());
//        System.out.println(numbers.indexOf(20));
//        System.out.println(numbers.indexOf(40));
//        
//        System.out.println(numbers);
//        System.out.println();
//        
//        ArrayList.ListIterator it = numbers.listIterator();
//        while(it.hasNext()) {
//        	int value = (int)it.next();
//        	System.out.println(value);
//        }
    }
 
}