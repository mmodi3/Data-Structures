package lists;

public class MyListLL<E> {

  private class Node<E> {
    //Data Fields
    private E data;
    private Node<E> next;
    //Constructors
    Node(E data) {
      this.data = data;
      this.next = null;
    }
    Node(E data, Node<E> next){
      this.data = data;
      this.next = next;
    }
  }
  //Data Fields
  private Node<E> head;
  private int size;

  //Constructor
  MyListLL() {
    head = null;
    size = 0;
  }

  public boolean add(E item){
    head = new Node<E>(item,head);
    size++;
    return true;
  }

  public boolean addLast(E item){
    if (head == null){
      head = new Node<E>(item);
    }else{
      Node<E> current=head;
      while (current.next != null){
        current = current.next;
      }
      current.next = new Node<E>(item);
    }
    size++;
    return true;
  }

  public E removeFirst(){
    if (head == null) {
      throw new IllegalArgumentException();
    }
  E temp = head.data;
  head = head.next;
  size--;
  return temp;
  }

  public E removeLast(){
    if (head == null){
      throw new IllegalArgumentException();
    }
    if (head.next == null){
      E temp = head.data;
      head = null;
      size--;
      return temp;
      }
    Node<E> current = head;
    while (current.next.next != null){
      current = current.next;
    }
    E temp = current.next.data;
    current.next = null;
    size--;
    return temp;
  }

  public E remove(int index){
    if (index < 0 || index > size - 1) {
      throw new IllegalArgumentException("Index is out of bounds");
    }
    if (index == 0) {
      E temp = head.data;
      return this.removeFirst();
    }
    else{
    Node<E> current = head;
    int a = 0;
      while (a != index - 1){
        current = current.next;
        a ++;
      }
      E temp = current.next.data;
      current.next = current.next.next;
      size--;
      return temp;
    }
  }

  public Node<E> get(int index){
    if (index < 0 || index > size){
      throw new IllegalArgumentException();
    }
    Node<E> current = head;
    for (int i = 0; i < index; i++){
        current = current.next;
      }
    return current;
  }

  public void reverse(){
    if (head == null){
      throw new IllegalArgumentException();
    }
    Node<E> previous = head;
    Node<E> current = previous.next;
    Node<E> next = current.next;
  }


  public String toString() {
    String r = "";
    Node<E> current=head;

    while (current != null) {
      r = r + ","+current.data;
      current = current.next;
    }
    return r;
  }

  private boolean isSingleton(Node<E> list){
    return list!=null && list.next==null;
  }
  private MyListLL<Pair<E,E>>.Node<Pair<E,E>> zip(Node<E> current1, Node<E> current2){
    if (current1 == null || current2 == null){
      return null;
    } else {

    }
  }
  /*public MyListLL<Pair<E,E>> zip(MyListLL<E> 12){
    MyListLL<Pair<E,E>> r = new MyListLL<Pair<E,E>>();
    r.size = Math.min(this.size, l2.size);
    r.head = zip(this.head, l2.head);
    return r; //Implement Me
  }*/
  private Node<E> take(int n, Node<E> current){
    if (n== 0 || current == null){
      return null;
    } else {
      return new Node<E>(current.data, take(n-1, current.next));
    }
  }

  private Node<E> take2(int n, Node<E> current){
    int ln = n;
    Node<E> lcurrent = current;
    Node<E> result = new Node<E>(null);
    Node<E> dummyHead = result;
    while (ln > 0 && lcurrent != null){
      result = new Node<E>(lcurrent.data);
      ln--;
      lcurrent = lcurrent.next;
      result = result.next;
    }
    return dummyHead.next;
  }

  public MyListLL<E> take(int n){
    MyListLL<E> result = new MyListLL<E>();
    result.size = Math.min(size, n);
    result.head = take(n,head);
    return result;
  }
  public static void main(String[] args) {
    MyListLL<String> l = new MyListLL<String>();
    l.add("Charly");
    l.add("Anne");
    l.add("Tom");
    l.add("Julia");
    l.addLast("Nicholas");
    System.out.println(l);
    System.out.println(l.take(0));
  }
}
