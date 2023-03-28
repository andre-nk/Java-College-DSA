public class TestCube {
  public static void main(String[] args) {
      //dekl
      Cube c1 = new Cube(2.0, 3.0, 4.0);
      Cube c2 = new Cube(2.0);
      Cube c3 = new Cube(3.0, 3.0, 3.0);
      
      System.out.println("c1 volume: " + c1.getVolume()); // expected output: 24.0
      System.out.println("c2 area: " + c2.getArea()); // expected output: 24.0
      System.out.println("c3 volume: " + c3.getVolume()); // expected output: 27.0
      
      System.out.println("c1 is larger than c2: " + c1.isLargerThan(c2)); // expected output: true
      System.out.println("c1 is larger than c3: " + c1.isLargerThan(c3)); // expected output: false
      
      Cube c4 = new Cube(4.0, 4.0, 4.0);
      Cube c5 = new Cube(2.0, 2.0, 2.0);

      c4.x0 = 0;
      c4.y0 = 0;

      c5.x0 = 5;
      c5.y0 = 5;
      
      System.out.println("c1 is intersecting with c4: " + c1.isIntersectingWith(c4)); // expected output: true
      System.out.println("c1 is intersecting with c5: " + c1.isIntersectingWith(c5)); // expected output: false
  }
}
