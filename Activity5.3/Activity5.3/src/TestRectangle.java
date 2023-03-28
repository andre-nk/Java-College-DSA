public class TestRectangle {

  public static void main(String[] args) {
    // Deklarasi objek r1, r2, dan r3
    Rectangle r1 = new Rectangle(1.0, 1.0);
    Rectangle r2 = new Rectangle(5.0);
    Rectangle r3 = new Rectangle(2.0, 6.0);

    // Test getArea() method
    System.out.println("r1 area: " + r1.getArea()); // expected output: r1 area: 12.0
    System.out.println("r2 area: " + r2.getArea()); // expected output: r2 area: 25.0

    // Test isLargerThan() method
    System.out.println("r1 is larger than r2: " + r1.isLargerThan(r2)); // expected output: r1 is larger than r2: false
    System.out.println("r2 is larger than r1: " + r2.isLargerThan(r1)); // expected output: r2 is larger than r1: true

    // Test isIntersectingWith() method
    r1.x0 = -1;
    r1.y0 = -1;

    r2.x0 = 0;
    r2.y0 = 0;

    r3.x0 = 3;
    r3.x0 = 3;

    System.out.println(
      "r1 is intersecting with r3: " + r1.isIntersectingWith(r3)
    ); // false

    System.out.println(
      "r1 is intersecting with r2: " + r1.isIntersectingWith(r2)
    ); // true

    System.out.println(
      "r2 is intersecting with r3: " + r2.isIntersectingWith(r3)
    ); // true
  }
}
