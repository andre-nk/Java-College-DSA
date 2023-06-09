public class Dijkstra {

  int nTown;
  double[][] map;
  double[] distance;
  int src;

  public Dijkstra(double[][] map) {
    this.map = map;
    nTown = map.length;
  }

  public void solve(int src, int dst) { //source and destination
    this.src = src;
    boolean[] selected = new boolean[nTown]; //visited node
    distance = new double[nTown];

    for (int i = 0; i < nTown; i++) {
      distance[i] = Double.MAX_VALUE; //max
      selected[i] = false;
    }

    distance[src] = 0;

    while (true) {
      int marked = minIndex(distance, selected); //Node with shortest Index
      if (marked < 0) return; //(-1), meaning no more Node to visit
      if (distance[marked] == Double.MAX_VALUE) return;

      //found valid Node to visit, then mark it as visited
      selected[marked] = true;

      //iterate nTown (dengan asumsi semua Node unvisited terhubung dengan marked)˝
      for (int j = 0; j < nTown; j++) {
        if (map[marked][j] > 0 && !selected[j]) { //jk ada direct edge dan belum dikunjungi
          double newDistance = distance[marked] + map[marked][j]; //current distance to marked + marked weight
          if (newDistance < distance[j]) { //if smaller
            distance[j] = newDistance; //update
          }
        }
      }
    }
  }

  private int minIndex(double[] distance, boolean[] selected) { //seek unvisited Node with shortest distance (in graph, everything is connected)
    double min = Double.MAX_VALUE; //contest
    int idx = -1; //current index (-1)
    for (int i = 0; i < nTown; i++) {
      if (!selected[i] && distance[i] < min) { //if not selected, and distance is less than min
        min = distance[i];
        idx = i;
      }
    }
    return idx;
  }

  public double getDistance(int dst) {
    return distance[dst]; //shortest distance
  }
}
