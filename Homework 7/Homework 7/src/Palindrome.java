import java.util.Scanner;
import java.util.Stack;

public class Palindrome {

  public static void main(String[] args) throws Exception {
    //Deklarasi stack
    Stack<String> stack = new Stack<String>();

    //Deklarasi scanner dan input kata
    Scanner scanner = new Scanner(System.in);
    System.out.println("Masukkan satu kata untuk (cek palindrome):");
    String word = scanner.nextLine();
    String reversedWord = "";

    //Memasukkan kata ke dalam Stack
    for (String letter : word.split("")) {
      stack.push(letter);
    }

    //Pop dan concatenate huruf menjadi reversedWord
    for(int i = 0; i < word.length(); i++){
        reversedWord += stack.pop();
    } 

    if(reversedWord.equals(word)){
      //palindrome
      System.out.println(word + " adalah palindrome dengan " + reversedWord);
    } else {
      //bukan palindrome
      System.out.println(word + " bukan palindrome dengan " + reversedWord);
    }

    //Menutup scanner
    scanner.close();
  }
}
