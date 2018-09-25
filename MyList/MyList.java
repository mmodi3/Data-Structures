package lists;

import java.util.Arrays;

public class MyList<E> {
	//Data Fields
	private E[] data;
	private int size;
	//Constructors
	MyList(int size) {
		this.data = (E[]) new Object[size];
		this.size= 0;

	}
	//Methods
	private void enlarge_array() {
		capacity = capacity*2;
		data = Arrays.copyof(data, capacity);
	}
	public void remove(int index){
		for (int i=index; i<size; i++){
			data[i] = data[i+1];
		}
		size--;
	}
	public boolean add (E item) {
		if (size == data.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		data[size] = item;
		size++;
		return true;
	}


	public void add(E item) {
		if (size == data.length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		data[size] = item;
		size++;
	}

	public String toString() {
		return Arrays.toString(data);
	}

	public static void main(String[] args) {
		MyList<Integer> is = new MyList<Integer>(5);
		/*MyList<String> ss null;

		ss.add("Hello");
		*/
		is.add(1);
		is.add(2);
		is.add(3);
		is.add(4);
		is.add(5);
		try {
		is.add(6);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("add failed when attempting to add 6");
		}
		System.out.println(is);
	}
}
