public class ArrayList<T> {
	// T will let it able to hold 
    private T[] elements;
    private int size;

    public ArrayList() {
    	// array list is default capacity 10 for the size when it initialized 
        elements = (T[]) new Object[10];
        // it record the size of the array
        size = 0;
    }

    public void add(T item) {
    	// I am doubling the array instead of increasing by 1.5
        if (size == elements.length) {
            T[] newArray = (T[]) new Object[elements.length * 2];
            
            // when it is full, 
            // the ArrayList class is creating a new array
            // copies all the elements from the old array to the new array
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        
        // add object to the list
        elements[size++] = item;
    }

    public T get(int index) {
    	
    	// if not in bounds throw out the exception
        if (index < 0 || index >= size)
        	throw new IndexOutOfBoundsException();
        // return the object
        return elements[index];
    }

    public T remove(int index) {
    	
    	// if not in bounds throw out the exception
        if (index < 0 || index >= size) 
        	throw new IndexOutOfBoundsException();
        
        // remove object from the given index
        T removed = elements[index];
        
        // move the object forwards;
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        
        elements[--size] = null;
        return removed;
    }

    public int size() {
    	
    	// return the size of array
        return size;
    }
    //Will help with debugging 
    public String toString() {
    	StringBuilder sb = new StringBuilder("[");
    	for(int i = 0; i < size; ++i) {
    		sb.append(elements[i]);
    		if(i < size - 1)sb.append(", ");
    	}
    	return sb.append("]").toString();
    	}
    }


