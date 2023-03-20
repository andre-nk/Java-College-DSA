public class TestPoint {
  //Method untuk increment point X dan decrement Y (sebanyak 1) dengan return type void (karena hanya mengubah reference)
  public static void changePoint(Point point){
    point.x++; //reference++
    point.y--; 
  }

  public static void main(String[] args){
    //inisialisasi
    Point samplePoint = new Point();
    samplePoint.x = 4;
    samplePoint.y = 5;

    //Print out sebelum diubah
    System.out.println("samplePoint sebelum diubah:");
    System.out.println("X: " + samplePoint.x);
    System.out.println("Y: " + samplePoint.y);

    //Invoke method
    changePoint(samplePoint);

    //Print out setelah diubah
    System.out.println("samplePoint setelah diubah:");
    System.out.println("X: " + samplePoint.x);
    System.out.println("Y: " + samplePoint.y);
  }
}
