class Node {

  int val;
  Node next;

  public Node(int val, Node next) {
    this.val = val;
    this.next = next;
  }
}

public class FrontRearQueue {

  Node front;

  public FrontRearQueue() {
    this.front = null;
  }

  public void enqueue(int val) {
    Node current = this.front;

    if (current != null) {
      while (current.next != null) {
        current = current.next;
      }

      Node newRear = new Node(val, null);
      current.next = newRear;
    } else {
      Node newNode = new Node(val, null);
      this.front = newNode;
    }
  }

  public int dequeueFront() throws Exception {
    Node current = this.front;

    if (current != null) {
      int output = current.val;
      this.front = current.next;
      return output;
    } else {
      throw new Exception("Queue is empty!");
    }
  }

  public int dequeueRear() throws Exception {
    Node current = this.front;

    if (current != null) {
      while (current.next.next != null) {
        current = current.next;
      }

      int out = current.next.val;
      current.next = null;
      return out;
    } else {
      throw new Exception("Queue is empty!");
    }
  }

  public void print(){
    Node current = this.front;

    if(current != null){
      while(current != null){
        if(current.next == null){
          System.out.print(current.val);
        } else {
          System.out.print(current.val + " - ");
        }
        current = current.next;
      }

      System.out.println();
    }
  }

  public static void main(String[] args) throws Exception{
    FrontRearQueue queue = new FrontRearQueue();

    queue.enqueue(1);
    queue.enqueue(2);
    queue.enqueue(3);
    
    queue.print();

    queue.dequeueFront();
    queue.print();

    queue.dequeueRear();
    queue.print();
  }
}
