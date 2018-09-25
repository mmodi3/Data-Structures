package dll;
import java.util.ArrayList;
import java.lang.IllegalArgumentException;
/**
 * Class that builds an Indexed Double Linked List.
 * @author Mitra Modi
 * I pledge my honor that I have abided by the Stevens Honor System.
 * @param <E> 
 */
public class IDLList<E> {
	/**
	 * A private class that builds a single Node object for an Indexed Double Linked List.
	 * @author Mitra Modi
	 *
	 * @param <E>
	 */
  public class Node<F> {
    //Data Fields
    F data;
    Node<F> next;
    Node<F> prev;

    //Constructors

    //Creates a new node holding elem as it's data, with next and previous null
    /**
	 * Constructor for the Node that sets the Data.
	 * @param elem
	 */
    Node(F elem){
    	
      data = elem;
      next = null;
      prev = null;
    }

    //Creates a new node holding elem as it's data, and next and prev are assigned accordingly
    /**
	 * Constructor for the Node that sets the Data, Previous Node, and Next Node.
	 * @param elem
	 * @param prev
	 * @param next
	 */
    Node(F elem, Node<F> prev, Node<F> next){
    	
      data = elem;
      this.prev = prev;
      this.next = next;
    }
  }

  //Data Fields
  private Node<E> head;
  private Node<E> tail;
  private int size;
  private ArrayList<Node<E>> indices;

  //Constructors
  //Creates an empty Double Linked List
  /**
	 * Constructor for an empty Indexed Linked List.
	 */
  IDLList(){
    head = null;
    tail = null;
    size = 0;
    indices = new ArrayList<Node<E>>();
  }

  //Methods
  /**
	  * Adds a Node at a specified index of the IDLL.
	  * @param index
	  * @param elem
	  * @return true
	  */
  public boolean add(int index, E elem){
    if (index < 0 || index > size){
      throw new IllegalArgumentException();
    }
    if (head == null){
      Node<E> temp = new Node<E>(elem);
      head = temp;
      tail = temp;
      size++;
      indices.add(index, temp);
    } else if (index == 0){
      Node<E> temp = head;
      head = new Node<E>(elem, null, temp);
      temp.prev = head;
      indices.add(index, head);
      size++;
    } else if (index == size){
      Node<E> temp = tail;
      tail = new Node<E>(elem, temp, null);
      temp.next = tail;
      size++;
      indices.add(index, tail);
    } else {
      int i;
      Node<E> counter = head;
      for (i = 0; i < index - 1; i++){
        counter = counter.next;
      }
      Node<E> temp = new Node<E>(elem, counter, counter.next);
      temp.next.prev = temp;
      temp.prev.next = temp;
      size++;
      indices.add(index, temp);
    }
    return true;
  }

  /**
	  * Adds a Node at the beginning of the IDLL.
	  * @param elem
	  * @return true
	  */
  public boolean add(E elem){
    if (head == null){
      head = new Node<E>(elem, null, null);
      tail = head;
    } else {
      Node<E> temp = head;
      head = new Node<E>(elem, null, temp);
      temp.prev = head;
    }
    indices.add(head);
    size++;
    return true;
  }

  /**
	  * Adds a Node to the end of the IDLL.
	  * @param elem
	  * @return true
	  */
  public boolean append(E elem){
    if (head == null){
      tail = new Node<E>(elem, null, null);
      head = tail;
    } else {
      Node<E> temp = tail;
      tail = new Node<E>(elem, temp, null);
      temp.next = tail;
    }
    indices.add(size-1, tail);
    size++;
    return true;
  }

  /**
	  * Gets the data of a Node at a specified index in the IDLL.
	  * @param index
	  * @return data of the Node
	  */
  public E get(int index){
    if (head == null){
      throw new IllegalArgumentException();
    }
    Node<E> counter = head;
    int i;
    for (i = 0; i < index; i++){
      counter = counter.next;
    }
    return counter.data;
  }

  /**
	  * Gets the data of the first Node in the IDLL.
	  * @return data of the first Node
	  */
  public E getHead(){
    if (head == null){
      throw new IllegalArgumentException();
    } else {
      return head.data;
    }
  }

  /**
	 * Gets the data of the last Node in the IDLL.
	 * @return data of the last Node.
	 */
  public E getLast(){
    if (head == null){
      throw new IllegalArgumentException();
    } else {
      return tail.data;
    }
  }

  /**
	 * Gets the size of the IDLL.
	 * @return size of IDLL
	 */
  public int size(){
    return size;
  }

  /**
	 * Removes the first Node in the IDLL.
	 * @return data of the first Node
	 */
  public E remove(){
    if (head == null){
      throw new IllegalArgumentException();
    }
    Node<E> temp = head;
    head = head.next;
    head.next.prev = null;
    size--;
    indices.remove(0);
    return temp.data;
  }

  /**
	 * Removes the last Node in the IDLL.
	 * @return data of the last Node
	 */
  public E removeLast(){
    if (head == null){
      throw new IllegalArgumentException();
    }
    Node<E> temp = tail;
    tail = tail.prev;
    tail.next = null;
    size--;
    indices.remove(size-1);
    return temp.data;
  }

  /**
	 * Removes the Node at a specified index in the IDLL.
	 * @param index
	 * @return data of the removed Node
	 */
  public E removeAt(int index){
    if (index < 0 || index > size - 1){
      throw new IllegalArgumentException();
    } 
    indices.remove(index);
    if (index == 0){
      Node<E> temp = head;
      head = head.next;
      head.next.prev = null;
      size--;
      return temp.data;
    } else if (index == size - 1){
      Node<E> temp = tail;
      tail = tail.prev;
      tail.next = null;
      size--;
      return temp.data;
    } else {
    Node<E> counter = head;
    int i;
    for (i = 0; i < index - 1; i++){
      counter = counter.next;
    }
    E temp = counter.next.data;
    counter.next = counter.next.next;
    counter.next.prev = counter;
    size--;
    return temp;
    }
  }

  /**
	 * Removes a Node with specified data in the IDLL.
	 * @param elem
	 * @return true if Node with specified data is found, false otherwise
	 */
  public boolean remove(E elem){
    if (size == 0){
      return false;
    } else {
      Node<E> current = head;
      for (int i = 0; i < size; i++){
        if (current.data == elem){
          this.removeAt(i);
          indices.remove(i);
          return true;
        }
        current = current.next;
      }
      return false;
    }
  }
  
  /**
	 * Returns a string representation of the IDLL.
	 * @return string representation of the IDLL
	 */
  public String toString() {
    String r = "[";
    Node<E> current=head;
    while (current != null) {
      if (current.next != null){
        r = r + current.data + ",";
      } else {
        r = r + current.data + "]";
      }
      current = current.next;
    }
    return r;
  }

 public static void main(String[] args){
    IDLList<Integer> i = new IDLList<Integer>();
    System.out.println(i.add(2));
    System.out.println(i.add(1));
    System.out.println(i.add(0,0));
    System.out.println(i.add(2,4));
    System.out.println(i.add(2,3));
    System.out.println(i);
  }
}
