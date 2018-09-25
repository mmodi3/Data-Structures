package lists;
public class NodeInt {
  //Data Fields
  private Integer data;
  private NodeInt next;

  //Constructors
  NodeInt(Integer data){
    this.data = data;
    this.next = null;
  }
  NodeInt(Integer data, NodeInt next){
    this.data = data;
    this.next = next;
  }
  public int sizeR(){
    if (next == null){
      return 1;
    } else {
      return 1 + next.size();
    }
  }
  public int size(){
    NodeInt current = this;
    int a = 0;
    while (current != null){
      a++;
      current = current.next;
    }
    return a;
  }

  public boolean allPositive() {
    int a = 0;
    NodeInt current = this;
    while (current != null){
      if (current.data < 0){
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

  public NodeInt bump() {
    NodeInt current = this;
    NodeInt result = new NodeInt(null);
    NodeInt head = result;

    while (current != null){
      result.next = new NodeInt(current.data + 1);
      result = result.next;
      current = current.next;
    }
    return head.next;
  }

  public NodeInt bumpR() {
    if (next == null){
      return new NodeInt(data + 1);
    } else {
      return new NodeInt(data + 1, next.bumpR());
    }
  }

  public String toString() {
    String s = "";
    NodeInt current = this;
    while (current != null){
      s = s + current.data + ", ";
      current = current.next;
    }
    return s;
  }

  public static void main(String[] args){
    NodeInt n1 = new NodeInt(1);
    NodeInt n2 = new NodeInt(2, n1);
    NodeInt n3 = new NodeInt(3, n2);
    System.out.println(n3.size());
    System.out.println(n3.allPositive());
    System.out.println(n3);
    System.out.println(n3.bumpR());
    System.out.println(n3.bump());
  }
}
