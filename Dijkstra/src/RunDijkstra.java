import java.util.Scanner;

public class RunDijkstra {

  static double[][] map;
  static int src;
  static int dst;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Masukkan jumlah Node");
    int nTown = sc.nextInt();
    map = new double[nTown][nTown];

    // INITIALIZ
    System.out.println("Enter the weights of the edges between nodes:");
    for (int i = 0; i < nTown; i++) {
      for (int j = 0; j < nTown; j++) {
        System.out.print("Enter weight for edge (" + i + ", " + j + "): ");
        map[i][j] = sc.nextDouble();
      }
    }

    System.out.println("Masukkan starting Node");
    src = sc.nextInt();
    System.out.println("Masukkan destination Node");
    dst = sc.nextInt();

    Dijkstra dj = new Dijkstra(map);
    dj.solve(src, dst);
    System.out.println(dj.getDistance(dst));

    sc.close();
  }
}
