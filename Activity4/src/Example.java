public class Example {

  public static void methodA(int[] a) {
    a[0]++; //increment the value of a[0]
  }

  public static void main(String[] args) {
    int[] a = new int[2];
    a[0] = 10;
    a[1] = 10;
    methodA(a);

    //the value of a after methodA is called
    System.out.println(a[0]); //? This will be 11 because a[0]++ above, will increment the reference
    System.out.println(a[1]);
  }
}
