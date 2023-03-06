public class TestCat {

  public static void main(String[] args) {
    Cat cat1 = new Cat();
    cat1.name = "Luna";
    Cat cat2 = new Cat();
    cat2.name = "Simba";
    Cat cat3 = cat2;
    System.out.println(cat3.name);
    cat3.name = "Milo";
    System.out.println(cat2.name);
  }
}
