package queues;

import java.util.NoSuchElementException;

public class QueueLL<E extends Comparable<E>> {

		public class Node<F> {
			// Data fields
			private F data;
			Node<F> next;
			//Constructor
			Node(F item) {
				data=item;
				next=null;
			}
			Node(F item,Node<F> next) {
				data=item;
				this.next=next;
			}
		}
		// Data fields
		Node<E> front;
		Node<E> rear;
		int size=0;

		// Constructor
		QueueLL() {
			front=null;
			rear=null;
			size=0;
		}

		// Methods

		/**
		 * Returns entry at front of queue without removing it. If the
		   queue is empty, throws NoSuchElementException
		 * @return
		 */
		public E element() {
			if (size == 0){
				throw new NoSuchElementException();
			} else {
				return front.data;
			}
		}

		/**
		 * Insert an item at the rear of a queue
		 * @param item
		 * @return
		 */
		public boolean offer(E item) {
			if (front == null){
				front = new Node<E>(item);
				rear = front;
				size=1;
			} else {
				rear.next = new Node<E>(item);
				rear = rear.next;
				size++;
			}
			return true;
	  }

		/**
		 * Removes an entry from the front of the
		 * queue if it is not empty. If the
		   queue is empty, throws NoSuchElementException
		 * @return
		 */
		public E remove() {
			if (size == 0){
				throw new NoSuchElementException();
			} else {
				E temp = element();
		    front = front.next;
				if (front == null){//Queue is empty after removal
					rear = null;
				}
		    size--;
		    return temp;
		    }
		}

		public boolean empty(){
			return front==null;
		}

		/**
		 * Returns the size of the queue
		 * @return
		 */
		public int size() {
			return size;
		}

		public QueueLL<E> merge(QueueLL<E> q2){
			QueueLL<E> result = new QueueLL<E>();
			while (!this.empty() &&  !q2.empty()) {
				if(this.element().compareTo(q2.element())<0){
					result.offer(this.remove());
				}else{
					result.offer(q2.remove());
				}
			}
			if(!(this.empty())){
				while (!(this.empty())){
					result.offer(this.remove());
				}
			}
			if(!(q2.empty())){
				while (!(q2.empty())){
					result.offer(q2.remove());
				}
			}
			return result;
		}

		public String toString() {
	    String r = "";
	    Node<E> current = front;

	    while (current != null) {
					r = r + current.data + ',' + ' ';
		      current = current.next;

	    }
	    return r;
	  }

		public static void main(String[] args){
			QueueLL<Integer> q = new QueueLL<Integer>();
			System.out.println(q.offer(1));
			System.out.println(q.offer(4));
			System.out.println(q.offer(7));

			/*System.out.println(q);
			System.out.println(q.remove());
			System.out.println(q.remove());
			System.out.println(q.remove());
			System.out.println(q);*/

			QueueLL<Integer> q2 = new QueueLL<Integer>();
			System.out.println(q2.offer(3));
			System.out.println(q2.offer(5));
			System.out.println(q2.offer(8));

			System.out.println(q.merge(q2));

		}
}
