package stacks;
import java.util.ArrayList;
public class IDLList<E> {



  public class Node<E> {
    //Data Fields
    E data;
    Node<E> next;
    Node<E> prev;

    //Constructors

    //Creates a new node holding elem as it's data, with next and previous null
    Node(E elem){
      data = elem;
      next = null;
      prev = null;
    }

    //Creates a new node holding elem as it's data, and next and prev are assigned accordingly
    Node(E elem, Node<E> prev, Node<E> next){
      data = elem;
      this.prev = prev;
      this.next = next;
    }
  }

  //Data Fields
  Node<E> head;
  Node<E> tail;
  int size;
  ArrayList<Node<E>> indices;

  //Constructors
  //Creates an empty Double Linked List
  IDLList(){
    head = null;
    tail = null;
    size = 0;
    indices = null;
  }

  //Methods


  public boolean add(E elem){
    head = new Node<E>(elem, null, head);
    size++;
    return true;
  }


  public static void main(String[] args){
    IDLList<Integer> i = new IDLList<Integer>();
    System.out.println(i.add(1));
  }
}
