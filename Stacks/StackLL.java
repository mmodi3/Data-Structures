package stacks;
import java.util.EmptyStackException;
public class StackLL<E> implements StackInt<E>{

  public class Node<E> {
    //Data fields
    private E data;
    private Node<E> next;

    //Constructors
    Node(E item) {
      data = item;
      next = null;
    }

    Node(E item, Node<E> next) {
      data = item;
      this.next = next;
    }
  }
  //Data Fields
  private Node<E> topmost;
  private int size;

  //Constructor
  StackLL() {
    topmost = null;
    size = 0;
  }

  //Methods

  public E push (E item) {
    topmost = new Node<E>(item, topmost);
    size++;
    return item;
  }

  public StackLL<E> push2 (E item) {
    topmost = new Node<E>(item,topmost);
    size++;
    return this;
  }

  public E top(){
    if (size == 0) {
      throw new EmptyStackException();
    }
    return topmost.data;
  }

  public E pop(){
    E temp = top();
    topmost = topmost.next;
    size--;
    return temp;
    }

  public boolean empty(){
    return topmost == null;
  }

  public static void main(String[] args) throws Exception{
    StackInt<Integer> s = new StackLL();
    System.out.println(s.push(1));
    System.out.println(s.push(2));
    System.out.println(s.push(3));



  }
}
