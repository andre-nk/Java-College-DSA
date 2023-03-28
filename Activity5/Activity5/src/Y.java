public class Y extends X {

  Y() {
    //karena method super() tidak dipanggil,
    //compiler Java akan menambahkan method super() secara default
    System.out.println("[Y]");
  }

  public void a() {
    System.out.println("[y.a]");
  }
}
