import java.util.Scanner;
import java.util.Vector;

class Vertex {

  String name;

  public Vertex(String name) {
    this.name = name;
  }
}

class Edge {

  Vertex vertexA;
  Vertex vertexB;
  int weight;

  public Edge(Vertex vertexA, Vertex vertexB, int weight) {
    this.vertexA = vertexA;
    this.vertexB = vertexB;
    this.weight = weight;
  }
}

public class MaximumFlow {

  public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in); //scanner
    Vector<Vertex> vertices = new Vector<Vertex>(); //vertices
    Vector<Edge> edges = new Vector<Edge>(); //edges

    String[] stnm = scanner.nextLine().split(" "); //edges count
    Integer mRaw = Integer.parseInt(stnm[stnm.length - 1]);

    System.out.println("");

    String sRaw = scanner.nextLine(); //root name
    vertices.add(new Vertex(sRaw));
    System.out.println("");

    String tRaw = scanner.nextLine(); //tail name
    vertices.add(new Vertex(tRaw));
    System.out.println("");

    String[] nRaw = scanner.nextLine().split(" "); //intersections

    for (String inter : nRaw) {
      vertices.add(new Vertex(inter));
    }
    System.out.println("");
    System.out.println(vertices.size());
    System.out.println("");

    for (int i = 0; i < mRaw; i++) { //edges connection
      String[] edgeRaw = scanner.nextLine().split(" ");
      Integer weight = Integer.parseInt(edgeRaw[2]);

      for (Vertex verticeA : vertices) {
        if (verticeA.name.equals(edgeRaw[0])) {
          for (Vertex verticeB : vertices) {
            if (verticeB.name.equals(edgeRaw[1])) {
              Edge edge = new Edge(verticeA, verticeB, weight);
              edges.add(edge);
            }
          }
        }
      }
      System.out.println("");
      System.out.println(edges.size());
      System.out.println("");
    }

    scanner.close();

    //loop through edges, to find all edges that contains root and tail
    Vertex rootVertex = vertices.get(0);
    Vertex tailVertex = vertices.get(1);

    Vector<Edge> rootEdges = new Vector<Edge>();
    Vector<Edge> tailEdges = new Vector<Edge>();

    //..
    //jumlahkan weight rootEdges

    for (Edge edge : edges) {
      if (edge.vertexA == rootVertex || edge.vertexB == rootVertex) { //? Apakah root bisa dipoint?
        rootEdges.add(edge);
      } else if (edge.vertexB == tailVertex){
        tailEdges.add(edge);
      } 
    }

    //while (lanjut)
        //pick adjacent edges yang maximum, masukkan ke dalam stack
        //lanjut terus sampai ke vertex tail
        //setelah sampai ke vertex tail, augmented path (dalam bentuk stack) sudah jadi,
            //lakukan pop, sambil mengurangi weight dari setiap edge sesuai dengan weight anggota edge yang terkecil
            //jika stlh pengurangan, weight edge = 0, hapus edge dari Vector edges


    //maximum flow adalah hasil pengurangan weight rootEdges awal dengan weight rootEdges terkini
  }
}
