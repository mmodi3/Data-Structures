package trees;

package;

import java.util.ArrayList;
import java.util.Collections;



public class Heap<E extends Comparable<E>> {
	private ArrayList<E> data;

	/**
	 * Constructor for a new heap
	 */
	public HeapRec() {
		this.data = new ArrayList<E>();
	}

	/**
	 * tells whether or not heap is empty
	 * 
	 * @return true if empty, false otherwise
	 */
	public boolean isEmpty() {
		return (this.size() == 0);
	}

	/**
	 * size of the heap
	 * 
	 * @return size of heap
	 */
	public int size() {
		return this.data.size();
	}

	/**
	 * returns element of heap at given index
	 * 
	 * @return element at given index
	 */
	public E get(int index) {
		return this.data.get(index);
	}

	/**
	 * returns minimal element of heap
	 * 
	 * @throws HeapException
	 *             if heap is empty
	 * @return minimal element of heap
	 */
	public E getMin() throws Exception {
		if (this.isEmpty()) {
			throw new Exception("Heap is empty");
		} else {
			return this.get(0);
		}
	}

	/**
	 * gets index of left child for a given node
	 * 
	 * @param curr
	 *            index of current node
	 * @return index of left child
	 */
	public int getLeft(int curr) {
		return 2 * curr + 1;
	}

	/**
	 * gets index of right child for a given node
	 * 
	 * @param curr
	 *            index of current node
	 * @return index of right child
	 */
	public int getRight(int curr) {
		return 2 * curr + 2;
	}

	/**
	 * gets index of parent for a given node
	 * 
	 * @param curr
	 *            index of current node
	 * @return index of parent
	 */
	public int getParent(int curr) {
		return (curr - 1) / 2;
	}

	/**
	 * inserts an element into the heap
	 * 
	 * @param elem
	 *            element to insert
	 */
	public boolean offer(E elem) {
		this.data.add(elem);
		reheapUp(this.size() - 1);
		return true;
	}

	/**
	 * reheap procedure for inserting (sift up)
	 * 
	 * @param curr
	 *            index of current node
	 */
	public void reheapUp(int curr) {
		int p;
		if (curr != 0) {
			p = getParent(curr);
			if (this.get(p).compareTo(this.get(curr)) > 0) {
				Collections.swap(this.data, p, curr);
				reheapUp(p);
			}
		}
	}

	/**
	 * reheap procedure for removing (sift down)
	 * 
	 * @param curr
	 *            index of current node
	 */
	public void reheapDown(int curr) {
		int l, r, min;
		l = getLeft(curr);
		r = getRight(curr);
		if (r >= this.size()) {
			if (l >= this.size())
				return;
			else
				min = l;
		} else {
			if (this.get(l).compareTo(this.get(r)) <= 0)
				min = l;
			else
				min = r;
		}
		if (this.get(curr).compareTo(this.get(min)) > 0) {
			Collections.swap(this.data, min, curr);
			reheapDown(min);
		}
	}

}
