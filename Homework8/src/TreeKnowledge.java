import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Deklarasi BinaryTreeNode
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
  public void print(BinaryTreeNode root) {
    List<List<String>> lines = new ArrayList<>(); // Daftar untuk menyimpan baris-baris pohon

    List<BinaryTreeNode> level = new ArrayList<>(); // Node pada level saat ini
    List<BinaryTreeNode> next = new ArrayList<>(); // Node pada level selanjutnya

    level.add(root); // Menambahkan node akar ke level saat ini
    int nn = 1; // Jumlah node pada level saat ini

    int widest = 0; // Lebar label node terlebar

    while (nn != 0) {
      List<String> line = new ArrayList<>(); // Baris pada level saat ini

      nn = 0; // Mengatur ulang jumlah node pada level selanjutnya

      for (BinaryTreeNode n : level) {
        if (n == null) {
          line.add(null); // Menambahkan null ke baris jika node kosong

          next.add(null);
          next.add(null);
        } else {
          String aa = n.label;
          line.add(aa); // Menambahkan label node ke baris
          if (aa.length() > widest) widest = aa.length(); // Memperbarui lebar terlebar

          next.add(n.left);
          next.add(n.right);

          if (n.left != null) nn++; // Menghitung jumlah node pada level selanjutnya
          if (n.right != null) nn++;
        }
      }

      lines.add(line); // Menambahkan baris ke daftar baris

      List<BinaryTreeNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = lines.get(lines.size() - 1).size() * (widest + 1); // Jumlah karakter per bagian pada setiap node pada baris tertentu
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i); // Mengambil baris pada level tertentu
      int hpw = (int) Math.floor(perpiece / 2f) - 1; // Jumlah karakter di setengah bagian per node pada baris tertentu

      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {
          // Membagi node
          char c = ' ';
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? '┴' : '┘'; // Tanda pembagi jika node memiliki anak kiri atau tidak
            } else {
              if (j < line.size() && line.get(j) != null) c = '└'; // Tanda pembagi jika node tidak memiliki anak kiri
            }
          }
          System.out.print(c);

          // Garis dan spasi
          if (line.get(j) == null) {
            for (int k = 0; k < perpiece - 1; k++) {
              System.out.print(" ");
            }
          } else {
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? " " : "-"); // Tanda garis di sekitar node
            }
            System.out.print(j % 2 == 0 ? "┌" : "┐"); // Tanda pembagi di atas node
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? "-" : " "); // Tanda garis di sekitar node
            }
          }
        }
        System.out.println();
      }

      for (int j = 0; j < line.size(); j++) {
        String f = line.get(j);
        if (f == null) f = "";
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f); // Jarak di sebelah kiri angka
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f); // Jarak di sebelah kanan angka

        for (int k = 0; k < gap1; k++) {
          System.out.print(" ");
        }
        System.out.print(f);
        for (int k = 0; k < gap2; k++) {
          System.out.print(" ");
        }
      }
      System.out.println();

      perpiece /= 2; // Memperbarui jumlah karakter per bagian untuk baris berikutnya
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
          System.out.print("Apakah benda tersebut " + x.label + " (y/n)? "); // Menanyakan apakah benda yang dipikirkan benar dengan benda yang ditunjuk oleh node saat ini
          if (YorN()) {
            System.out.println("Saya menang!"); // Menampilkan pesan jika tebakan benar
            break;
          } else {
            System.out.println("Beri tahu jawabannya"); // Meminta informasi mengenai benda yang dipikirkan
            String newAnswer = sc.next();

            System.out.println(
              "Masukkan pertanyaan yang jika dijawab YES adalah " +
              newAnswer +
              " dan jika dijawab NO adalah " +
              x.label
            );

            sc.nextLine(); // Mengonsumsi karakter newline
            String newQuestion = sc.nextLine();

            BinaryTreeNode newLeft = new BinaryTreeNode(newAnswer, null, null); // Membuat node baru untuk jawaban yang benar
            BinaryTreeNode newRight = new BinaryTreeNode(x.label, null, null); // Membuat node baru untuk jawaban yang salah
            x.label = newQuestion; // Mengubah pertanyaan pada node saat ini dengan pertanyaan baru
            x.left = newLeft; // Menghubungkan node saat ini dengan node jawaban yang benar
            x.right = newRight; // Menghubungkan node saat ini dengan node jawaban yang salah
            break;
          }
        } else {
          System.out.print(x.label + " (y/n)? "); // Menanyakan pertanyaan berdasarkan label pada node saat ini
          if (YorN()) {
            x = x.left; // Pindah ke anak kiri jika jawaban adalah "ya"
          } else {
            x = x.right; // Pindah ke anak kanan jika jawaban adalah "tidak"
          }
        }
      }

      System.out.print("Lanjut (y/n)? "); // Menanyakan apakah ingin melanjutkan permainan
      if (!YorN()) {
        break; // Berhenti jika jawaban adalah "tidak"
      }

      print(); // Menampilkan struktur pohon setelah satu permainan selesai
    }

    print(); // Menampilkan struktur pohon terakhir setelah selesai semua permainan
  }

  public static void main(String[] args) {
    TreeKnowledge tk = new TreeKnowledge(new Scanner(System.in));
    tk.run();
  }
}
