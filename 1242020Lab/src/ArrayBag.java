

/**
 * This is a skeleton for the ArrayBag implementation
 * detailed in our text book. You should fill in
 * all methods and constructors based on the code
 * in the book (or use what we worked on in class).
 * Note that you do not need to worry about resizing
 * the underlying array container when the array is
 * full. This is a fixed-size bag.
 * 
 * @author Jacob Schrum
 * Last modified 5/29/18
 */
public class ArrayBag<T> implements BagInterface<T> {

	private static final int DEFAULT_CAPACITY = 25;
	private T[] data;
	private int size;
	public ArrayBag() {
		this(DEFAULT_CAPACITY);
	}
	
	public ArrayBag(int capacity) {
		// TODO Auto-generated constructor stub
		@SuppressWarnings("unchecked")
		T[] temp =(T[]) new Object[capacity];
		data = temp;
		size = 0; //nothing in bag yet 
		
	}

	@Override
	public int getCurrentSize() {
		// TODO Auto-generated method stub
		return size;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return size == 0;
	}

	@Override
	public boolean add(T newEntry) {
		if(size >= data.length) return false;
		else {
			data[size] = newEntry;
			size++;
			return true;
		}
	}

	@Override
	public T remove() {
		if(size == 0 ) return null;
		size--;
		
		T result = data[size];
		
		data[size] = null;
		return result;
	}

	@Override
	public boolean remove(T anEntry) {
		boolean found = false;
		int index = 0;
		while(index < size && !(found)) {
			if(data[index].equals(anEntry)) {
				found = true;
			} else {
				index++;
			}
			
		}
	
		if(found) {
			size--;
			for(int i = index; i < size; i++) {
				data[i] = data[i+1];
				
			}
			data[size] = null;
		}
		
		return found;
		
	}

	@Override
	public void clear() {
		for(int i = 0; i < data.length; i++) {
			data[i] = null;
		}
		size = 0;
		
	}

	@Override
	public int getFrequencyOf(T anEntry) {
		int counter = 0;
		for(int i = 0; i < size; i++) {
			if(data[i].equals(anEntry)) counter++;
		}
		return counter;
	}

	@Override
	public boolean contains(T anEntry) {
		
		for(int i = 0; i < size; i++) {
			if(data[i].equals(anEntry)) return true;
		}
		return false;
	}

	@Override
	public T[] toArray() {
		// TODO Auto-generated method stub
		@SuppressWarnings("unchecked")
		T[] result = (T[]) new Object[size];
		for(int i = 0; i < size; i++) {
			result[i] = data[i];
		}
		return result;
	}
	
}
