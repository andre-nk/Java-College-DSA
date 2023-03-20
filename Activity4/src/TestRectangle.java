public class TestRectangle {

  public static void main(String[] args) {
    //inisialisasi dua Rectangle
    Rectangle rectA = new Rectangle(4, 5);
    Rectangle rectB = new Rectangle(3, 4);

    //Print out masing-masing luas Rectangle
    System.out.println("Luas area rectA: " + rectA.getArea());
    System.out.println("Luas area rectB: " + rectB.getArea());

    //Print out hasil perbandingan luas kedua Rectangle
    System.out.println(
      "Apakah rectA lebih besar dari rectB? " + rectA.isLarger(rectB)
    );
    System.out.println(
      "Apakah rectB lebih besar dari rectA? " + rectB.isLarger(rectA)
    );
  }
}
