public class RandomExample {
  public static void main(String[] args) {
    //Homework 1.1: add codes to generate:
    //Formula: (lowerBound + (Math.random() * (upperBound + 1)))

    //a) 0,1,2,3
    System.out.println(0 + (int) (Math.random() * 4));

    //b) 1,2,3,4,5,6
    System.out.println(1 + (int) (Math.random() * 6));

    //c) 2,4,6,8
    System.out.println(2 * (1 + (int) (Math.random() * 4)));

    //d) -5,-4,...,4,5
    System.out.println(-5 + (int) (Math.random() * 6));
  }
}
