public class Activity1_2 {

  public static double random() {
    return Math.random();
  }

  public static int randomZeroToNine() {
    return (0 + (int) (Math.random() * 10));
  }

  public static int randomZeroToThree() {
    return (0 + (int) (Math.random() * 4));
  }

  public static int randomOneToSix() {
    return (1 + (int) (Math.random() * 7));
  }

  public static int randomFirstFourEven() {
    return 2 * (1 + (int) (Math.random() * 4));
  }

  public static void main(String[] args) throws Exception {
    System.out.println("-) Random numbers (double): " + random());
    System.out.println("a.) Random integer (0 - 9): " + randomZeroToNine());
    System.out.println("b.) Random integer (0 - 3): " + randomZeroToThree());
    System.out.println("c.) Random integer (1 - 6): " + randomOneToSix());
    System.out.println(
      "d.) Random First Four Even Integer: " + randomFirstFourEven()
    );
  }
}
