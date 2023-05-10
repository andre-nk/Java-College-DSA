import java.util.Scanner;
import java.util.Stack;

public class Reverse {

  public static void main(String[] args) throws Exception {
    //Deklarasi stack
    Stack<String> stack = new Stack<String>();

    //Deklarasi scanner dan input kata
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan satu kata:");
    String word = scanner.nextLine();

    for (String letter : word.split("")) {
      stack.push(letter);
    }

    //Looping untuk pop(), sekaligus mencetak hasil pop() menjadi String terbalik
    for (int i = 0; i < word.length(); i++) {
      System.out.print(stack.pop());
    }

    //Menutup scanner
    scanner.close();
  }
}
