import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class BinaryTreeNode {

  String label;
  BinaryTreeNode left;
  BinaryTreeNode right;

  BinaryTreeNode(String label, BinaryTreeNode left, BinaryTreeNode right) {
    this.label = label;
    this.left = left;
    this.right = right;
  }

  public String toString() {
    return "[" + label + ", " + left + ", " + right + "]";
  }
}

class TreePrinter {

  public static void print(BinaryTreeNode root) {
    List<List<String>> lines = new ArrayList<>();

    List<BinaryTreeNode> level = new ArrayList<>();
    List<BinaryTreeNode> next = new ArrayList<>();

    level.add(root);
    int nn = 1;

    int widest = 0;

    while (nn != 0) {
      List<String> line = new ArrayList<>();

      nn = 0;

      for (BinaryTreeNode n : level) {
        if (n == null) {
          line.add(null);

          next.add(null);
          next.add(null);
        } else {
          String aa = n.label;
          line.add(aa);
          if (aa.length() > widest) widest = aa.length();

          next.add(n.left);
          next.add(n.right);

          if (n.left != null) nn++;
          if (n.right != null) nn++;
        }
      }

      if (widest % 2 == 1) widest++;

      lines.add(line);

      List<BinaryTreeNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = widest + 6;
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i);
      int hpw = (int) Math.floor(perpiece / 2f) - 1;

      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {
          // split node
          char c = ' ';
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? '┴' : '┘';
            } else {
              if (j < line.size() && line.get(j) != null) c = '└';
            }
          }
          System.out.print(c);

          // lines and spaces
          if (line.get(j) == null) {
            for (int k = 0; k < perpiece - 2; k++) {
              System.out.print(" ");
            }
          } else {
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? " " : "─");
            }
            System.out.print(j % 2 == 0 ? "┌" : "┐");
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? "─" : " ");
            }
            System.out.print(" ");
          }
        }
        System.out.println();
      }

      // print line of numbers
      for (int j = 0; j < line.size(); j++) {
        String f = line.get(j);
        if (f == null) f = "";
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f);
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f);

        // a number
        for (int k = 0; k < gap1; k++) {
          System.out.print(" ");
        }
        System.out.print(f);
        for (int k = 0; k < gap2; k++) {
          System.out.print(" ");
        }
      }
      System.out.println();

      perpiece /= 2;
    }
  }
}

public class TreeKnowledge {

  Scanner sc;
  BinaryTreeNode root;

  public TreeKnowledge(Scanner sc) {
    this.sc = sc;
    root = new BinaryTreeNode("Komputer", null, null);
  }

  public boolean YorN() {
    while (true) {
      String s = sc.next();
      if (s.startsWith("y")) {
        return true;
      } else if (s.startsWith("n")) {
        return false;
      }
    }
  }

  public void print() {
    TreePrinter printer = new TreePrinter();

    System.out.println("");
    printer.print(this.root);
    System.out.println("");
  }

  public void run() {
    while (true) {
      BinaryTreeNode x = root;

      System.out.println("Pikirkan sebuah benda!");
      while (true) {
        if (x.left == null && x.right == null) {
          System.out.print("Apakah benda tersebut " + x.label + " (y/n)? ");
          if (YorN()) {
            System.out.println("Saya menang!");
            break;
          } else {
            System.out.println("Beri tahu jawabannya");
            String newAnswer = sc.next();

            System.out.println(
              "Masukkan pertanyaan yang jika dijawab YES adalah " +
              newAnswer +
              " dan jika dijawab NO adalah " +
              x.label
            );

            sc.nextLine(); // Consume the newline character
            String newQuestion = sc.nextLine();

            BinaryTreeNode newLeft = new BinaryTreeNode(newAnswer, null, null);
            BinaryTreeNode newRight = new BinaryTreeNode(x.label, null, null);
            x.label = newQuestion;
            x.left = newLeft;
            x.right = newRight;
            break;
          }
        } else {
          System.out.print(x.label + " (y/n)? ");
          if (YorN()) {
            x = x.left;
          } else {
            x = x.right;
          }
        }
      }

      System.out.print("Lanjut (y/n)? ");
      if (!YorN()) {
        break;
      }
    }
  }

  public static void main(String[] args) {
    TreeKnowledge tk = new TreeKnowledge(new Scanner(System.in));
    tk.run();
    tk.print();
  }
}
