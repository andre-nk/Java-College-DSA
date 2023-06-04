import java.util.LinkedList;
import java.util.Scanner;

class MaxFlow {
  public int V;
  public MaxFlow(int size) {
    this.V = size;
  }

  int[][] generateGraph(int n, int m, Scanner scanner) {
    int graph[][] = new int[n + 2][n + 2];

    for (int i = 0; i < m; i++) {
      String[] edge = scanner.nextLine().split(" ");
      Integer vertexA = Integer.parseInt(edge[0]);
      Integer vertexB = Integer.parseInt(edge[1]);
      Integer weight = Integer.parseInt(edge[2]);

      graph[vertexA - 1][vertexB - 1] = weight;
    }

    return graph;
  }

  // Using BFS as a searching algorithm
  boolean bfs(int Graph[][], int s, int t, int p[]) {
    
    boolean visited[] = new boolean[V];
    for (int i = 0; i < V; ++i) visited[i] = false;

    LinkedList<Integer> queue = new LinkedList<Integer>();
    queue.add(s);
    visited[s] = true;
    p[s] = -1;

    while (queue.size() != 0) {
      int u = queue.poll();

      for (int v = 0; v < V; v++) {
        if (visited[v] == false && Graph[u][v] > 0) {
          queue.add(v);
          p[v] = u;
          visited[v] = true;
        }
      }
    }

    return (visited[t] == true);
  }

  // Applying Ford Fulkerson algorithm
  int fordFulkerson(int graph[][], int s, int t) {
    int u, v;
    int Graph[][] = new int[graph.length][V];

    for (u = 0; u < V; u++) for (v = 0; v < V; v++) Graph[u][v] = graph[u][v];

    int p[] = new int[V];

    int max_flow = 0;

    while (bfs(Graph, s, t, p)) {
      int path_flow = Integer.MAX_VALUE;
      for (v = t; v != s; v = p[v]) {
        u = p[v];
        path_flow = Math.min(path_flow, Graph[u][v]);
      }

      for (v = t; v != s; v = p[v]) {
        u = p[v];
        Graph[u][v] -= path_flow;
        Graph[v][u] += path_flow;
      }

      // Adding the path flows
      max_flow += path_flow;
    }

    return max_flow;
  }

  public static void main(String[] args) throws java.lang.Exception {
    Scanner scanner = new Scanner(System.in); //scanner

    String[] stnm = scanner.nextLine().split(" ");
    Integer s = Integer.parseInt(scanner.nextLine()) - 1;
    Integer t = Integer.parseInt(scanner.nextLine()) - 1;

    Integer n = Integer.parseInt(stnm[2]);
    Integer m = Integer.parseInt(stnm[3]);

    scanner.nextLine();

    MaxFlow maxFlow = new MaxFlow(n + 2);
    int graph[][] = maxFlow.generateGraph(n, m, scanner);

    System.out.println(maxFlow.fordFulkerson(graph, s, t));
  }
}
