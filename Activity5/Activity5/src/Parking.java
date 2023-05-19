import java.util.Stack;

public class Parking {

  public static boolean check(int[] arr) {
    Stack<Integer> stack = new Stack<Integer>();
    char mark = '-';

    for (int i = 0; i < arr.length; i++) {
      if (stack.empty()) {
        stack.push(arr[i]);
      } else {
        if (stack.peek() == arr[i] + 1 || stack.peek() == arr[i] - 1) { //beda satu
          if (mark == 'a' && arr[i] < stack.peek()) {
            return false;
          } else if (mark == 'd' && arr[i] > stack.peek()) {
            return false;
          } else {
            stack.push(arr[i]);
          }
        } else { //beda >1
          if (stack.size() != 1) {
            //marking
            int oldHead = stack.pop();

            if (oldHead > stack.peek()) {
              mark = 'a';
            } else {
              mark = 'd';
            }
          }

          stack.clear();
          stack.push(arr[i]);
        }
      }
    }

    return true;
  }

  public static void main(String[] args) {
    int[] test1 = { 3, 1, 2, 5, 4 }; //invalid test
    int[] test2 = { 2, 1, 4, 3, 5 }; //valid test
    int[] test3 = { 3, 2, 1, 5, 4 };
    int[] test4 = { 1, 2, 3, 4, 5 };
    int[] test5 = { 1, 5, 4, 3, 2 };
    int[] test6 = { 4, 3, 2, 1, 5 };

    System.out.println("Result (exp: false): " + check(test1));
    System.out.println("Result (exp: true): " + check(test2));
    System.out.println("Result (exp: true): " + check(test3));
    System.out.println("Result (exp: true): " + check(test4));
    System.out.println("Result (exp: true): " + check(test5));
    System.out.println("Result (exp: true): " + check(test6));
  }
}
