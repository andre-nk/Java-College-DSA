public class MultiplicationTable {
  public static void main(String[] args) {
    //title
    System.out.println("Multiplication Table");
    System.out.print("  |");

    //column headers (horizontal multiplier)
    for (int i = 1; i <= 9; i++) {
      System.out.printf("%9s", i + "     ");
    }
    
    //column header separator
    System.out.println("\n--+---------------------------------------------------------------------------------");
    
    //first loop (vertical rows)
    for (int i = 1; i <= 9; i++) {
      //row headers and separator (vertical multiplier)
      System.out.printf("%2d|", i);

      //second loop (horizontal element for each row)
      for (int j = 1; j <= 9; j++) {
        System.out.printf("%3s", " ");
        System.out.printf("%dx%d=%2d", i, j, (i * j));
      }

      //new line
      System.out.println();
    }
  }
}
