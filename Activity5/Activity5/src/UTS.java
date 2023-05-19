import java.util.LinkedList;
import java.util.Queue;

class Node {

  int val;
  Node next;

  public Node(int val) {
    this.val = val;
  }
}

class CircularLink {

  Node head;
  Node tail;
  int max;

  public CircularLink(int max) {
    this.max = max;
  }

  public void enqueue(int val) {
    Node current = head;
    int length = 0;

    if (current == null) {
      this.head = new Node(val);
      this.tail = head;
      head.next = tail;
    }

    while (current.next != null) {
      current = current.next;
      length++;
    }

    if (length < max) {
      Node newNode = new Node(val);
      current.next = newNode;
      tail = newNode;
      tail.next = head;
    }
  }

  public void dequeue() {
    Node current = head;
    int length = 0;

    if (current != null) {
      while (current.next != null && length < max) {
        current = current.next;
        length++;
      }

      if (length < max) {
        head = head.next;
        tail = current.next;
        tail.next = head;
      }
    }
  }
}

public class UTS {

  public static void olah() {
    char x[] = { 'O', 'M', 'I', 'C', 'R', 'O', 'N', 'S', 'I', 'R', 'N', 'A' };
    Queue<Character> Q = new LinkedList<Character>();

    for (int i = 0; i < 12; i++) {
      if (x[i] > 76) {
        System.out.println(x[i]);
        Q.add(x[i]);
      }
    }

    Q.remove();
    Q.add('E');
    Q.remove();
    Q.remove('N');
    Q.add('T');

    for (int i = 0; i < Q.size(); i++) {
      System.out.print(Q.toArray()[i] + " ");
    }
  }

  public static boolean isMakeSense(int[] array) {
    CircularLink link = new CircularLink(array.length);

    for (int i = 0; i < array.length; i++) {
      link.enqueue(i);
    }

    if(link.head.val == link.tail.val + 1 || link.head.val == link.tail.val - 1){
      Node current = link.head;  
      int length = 0;
      
      while(current != null && length < link.max){
        if(current.val != current.next.val + 1 || current.val != current.next.val - 1){
          return false;
        }

        current = current.next;
        length++;
      }
    } else {
      return false;
    }

    return true;
  }

  public static void main(String[] args) {
    int[] test = {3, 2, 1, 5, 4};

    olah();
    isMakeSense(test);
  }
}
