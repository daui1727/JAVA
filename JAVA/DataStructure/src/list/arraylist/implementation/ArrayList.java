package list.arraylist.implementation;
 
public class ArrayList {
    private int size = 0;
    private Object[] elementData = new Object[100];
    
    public boolean addLast(Object element) {
    	elementData[size] = element;
    	size++;
    	return true;
    }
    
    public boolean add(int index, Object element) {
    	for(int i = size-1;  i>= index; i--) {
    		elementData[i+1] = elementData[i];
    	}
    	elementData[index] = element;
    	size++;
    	return true;
    }
    
    public boolean addFirst(Object element) {
    	return add(0, element);
    }
    
    public String toString() {
    	String str = "[";
    	for(int i = 0; i < size; i++) {
    		str += elementData[i];
    		if(i < size-1) {
    			str += ",";
    		}
    	}
    	return str + "]";
    }
    
    public Object remove(int index) {
    	Object removed = elementData[index];
    	
    	for(int i = index + 1; i <= size-1; i++) {
    		elementData[i-1] = elementData[i];
    	}
    	size--;
    	elementData[size] = null;
    	return removed;
    	
    }
    
    public Object get(int index) {
    	return elementData[index];
    }
    
    public int size() {
    	return size;
    }
    
    public Object indexOf(Object o) {
    	for(int i = 0; i < size; i++) {
    		if(o.equals(elementData[i])) {
    			return i;
    		}
    	}
    	return -1;
    }
    
    public ListIterator listIterator() {
    	return new ListIterator();
    }
    public class ListIterator{
    	private int nextIndex = 0;
    	public boolean hasNext() {
    		return nextIndex < size();
    	}
    	public Object next() {
    		return elementData[nextIndex++];
    	}
    	public boolean hasPrevious() {
    		return nextIndex > 0;
    	}
    	public Object previous() {
    		return elementData[--nextIndex];
    	}
    	
    	public void add(Object element) {
    		ArrayList.this.add(nextIndex++, element);
    	}
    	public void remove() {
    		ArrayList.this.remove(nextIndex-1);
    		nextIndex--;
    	}
    }
    
    
    
    
    
    
    
    
    
}