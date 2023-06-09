import java.util.*;

public class Run2Dijkstra {
  static double[][] map;
  static int src;
  static int dst;

  public static void main(String[] args){
    doInput();
    Dijkstra dj = new Dijkstra(map);
    dj.solve(src, dst);
    System.out.println(dj.getDistance(dst));
  }

  static void doInput() {
    Scanner sc = new Scanner(System.in);
    int nTown = sc.nextInt();
    int nRoute = sc.nextInt();
    map = new double[nTown][nRoute]; // map[from][to] = length

    for(int i = 0; i < nRoute; i++){
      int from = sc.nextInt(); // from
      int to = sc.nextInt(); // to
      double len = sc.nextDouble(); // length
      map[from][to] = map[to][from] = len; // undirected graph
    }

    // source and destination
    src = sc.nextInt();
    dst = sc.nextInt();

    sc.close();
  }
}
