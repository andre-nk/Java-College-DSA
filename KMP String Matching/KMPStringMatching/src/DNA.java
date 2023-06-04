import java.util.Scanner;

public class DNA {

  public static int[] generateLPS(String s) {
    int len = 0;
    int i = 1;
    int lps[] = new int[s.length()];
    lps[0] = 0;

    while (i < s.length()) {
      if (s.charAt(i) == s.charAt(len)) {
        len++;
        lps[i] = len;
        i++;
      } else {
        if (len != 0) {
          len = lps[len - 1];
        } else {
          lps[i] = len;
          i++;
        }
      }
    }

    return lps;
  }

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);
    String g = scanner.nextLine();
    String h = scanner.nextLine();
    scanner.close();

    int[] lpsTable = generateLPS(h);

    int j = 0; 
    int i = 0;
    int count = 0;

    while (i < g.length()) {
      if (h.charAt(j) == g.charAt(i)) {
        j++;
        i++;
      }
      if (j == h.length()) {
        count++;
        j = lpsTable[j - 1];
      } else if (i < g.length() && h.charAt(j) != g.charAt(i)) {
        if (j != 0) {
          j = lpsTable[j - 1];
        } else {
          i++;
        }
      }
    }

    System.out.println(count);
  }
}
