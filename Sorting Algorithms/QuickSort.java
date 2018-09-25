package sorting;

import java.util.List;

public class QuickSort<E extends Comparable<E>> {
	
	public List<E> quickSort(List<E> list){
		quickSort(list, 0, list.size()-1);
		return list;
	}
	
	private void quickSort(List<E> l, int first, int last) {
		if (first < last) {
			int pivot = partition(l, first, last);
			quickSort(l, first, pivot-1);
			quickSort(l, pivot+1, last);
		}
	}
	
	private int partition(List<E> l, int first, int last) {
		int mid = first + (last-first)/2;
		bubbleSortThree(l,first,mid,last);
		int up = first;
		int down = last;
		
		do {
			while (up < last && l.get(up).compareTo(l.get(first)) <= 0){
				up++;
			}
			while(down > first && l.get(down).compareTo(l.get(last)) > 0) {
				down--;
			}
			if (up < down) {
				swap(l, up, down);
			}
		} while (up < down);
		
		swap(l, first, down);
		return down;
	}

	private void bubbleSortThree(List<E> list, int f, int m, int l) {
		if (list.get(f).compareTo(list.get(m))>0) {
			swap(list, f, m);
		}
		if (list.get(m).compareTo(list.get(l))>0) {
			swap(list, m, l);
		}
		if (list.get(f).compareTo(list.get(m))<0) {
			swap(list, f, m);
		}
	}
	
	private void swap(List<E> l, int a, int b) {
		E temp = l.get(a);
		l.set(a,  l.get(b));
		l.set(b, temp);
	}

}
