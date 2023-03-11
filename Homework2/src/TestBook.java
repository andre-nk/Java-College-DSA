public class TestBook {

  public static void main(String args[]) {
    //Deklarasi array of Buku
    Buku books[] = new Buku[3];
    
    //Pengisian data buku ke-1
    books[0] = new Buku();
    books[0].judul = "Introduction to Java Programming and Data Structures";
    books[0].penulis = "Daniel Liang";
    books[0].harga = 355000;

    //Pengisian data buku ke-2
    books[1] = new Buku();
    books[1].judul = "Advanced Java Programming";
    books[1].penulis = "Uttam Roy";
    books[1].harga = 236250;

    //Pengisian data buku ke-3
    books[2] = new Buku();
    books[2].judul = "Practical Java Programming";
    books[2].penulis = "Perry Xiao";
    books[2].harga = 95000;

    for(Buku book: books){
      //Perhitungan harga setelah pajak
      book.harga = book.harga + (0.1 * book.harga);

      //Printing
      System.out.println("Judul: " + book.judul);
      System.out.println("Penulis: " + book.penulis);
      System.out.println("Harga (+10% PPN): Rp" + book.harga);
    }
  }
}
