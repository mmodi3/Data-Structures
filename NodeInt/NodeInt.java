package quizzes;

public class NodeInt {
// Data fields
  private Integer data ;
  private NodeInt next ;
// Constructors
  NodeInt ( Integer data ) {
    this.data = data;
    this.next = null;
    }
  NodeInt ( Integer data , NodeInt next ) {
    this.data = data;
    this.next = next;
    }
  public boolean sortedRec(){
    if (this.next == null){
      return true;
    } else {
      return this.data <= this.data.next && this.next.sortedRec();
    }
  }

  public boolean sorted(){
    NodeInt current = this;
    int a = 0;
    while (current.next != null){
      if (current.data > current.next.data){
        a++;
      }
      current = current.next;
    }
    if (a > 0){
      return false;
    } else {
      return true;
    }
  }

  public NodeInt repeat(int n, Integer item){
    if (n == 1){
      return new NodeInt(item, null);
    } else {
      return new NodeInt(item, next.repeat(n-1, item));
    }
  }

  // public NodeInt stutter(int n) {
  //   if (current.next.data == null){
  //
  //   }
  public String toString(){
    if (next == null){
      return data.toString();
    } else {
      return data.toString() + "," + next.toString();
    }
  }


  public static void main(String[] args){
    NodeInt n1 = new NodeInt(2);
    NodeInt n2 = new NodeInt(2, n1);
    NodeInt n3 = new NodeInt(2, n2);
    NodeInt n4 = new NodeInt(2, n3);
    System.out.println(n4.sortedRec());
    System.out.println(n4.repeat(3,3));
  }
}
