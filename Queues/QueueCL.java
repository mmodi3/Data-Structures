package queues;
import java.util.NoSuchElementException;
public class QueueCL<E> {
  //Data Fields
  private E[] data;
  private int front, rear;
  private int size;
  private int capacity;
  private static final int INITIAL_CAPACITY=10;

  //Constructor
  QueueCL(){
    data = (E[]) new Object[INITIAL_CAPACITY];
    capacity = INITIAL_CAPACITY;
    front = 0;
    rear = capacity-1;
    size = 0;
  }

  //Methods
  public E remove(){
    if (size == 0){
      throw new NoSuchElementException();
    } else {
      E temp = data[front];
      front = (front + 1) % capacity;
      size--;
      return temp;
    }
  }

  public E element(){
    if (data[front] == null){
      throw new NoSuchElementException();
    } else {
      return data[front];
    }
  }

  public boolean offer(E item){
    if (size == capacity){
      QueueCL<E> temp = new QueueCL<E>();
      temp.capacity = this.capacity * 2;
      for(int i = 0; i < this.capacity; i++){
        temp.data[i] = this.remove();
      }
      temp.data[rear + 1] = item;
      this.capacity = temp.capacity;
      this.data = temp.data;
      this.front = 0;
      this.rear = capacity - 1;
      this.size = temp.size;
    } else {
      this.data[rear + 1] = item;
    }
    return true;
  }

  public int size(){
    int i = 0;
    return  i;
  }
  public static void main(String[] args){
    QueueCL<Integer> q = new QueueCL<Integer>();
    System.out.println(q.offer(1));
    System.out.println(q.offer(4));
    System.out.println(q.offer(7));

    /*System.out.println(q);
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q.remove());
    System.out.println(q);*/

    QueueCL<Integer> q2 = new QueueCL<Integer>();
    System.out.println(q2.offer(3));
    System.out.println(q2.offer(5));
    System.out.println(q2.offer(8));
  }



}
