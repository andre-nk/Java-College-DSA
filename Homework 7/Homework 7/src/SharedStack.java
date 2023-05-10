public class SharedStack {
  //Deklarasi fields
  int[] sharedArray; //sharing array
  int size; //ukuran array untuk kedua Stack (akumulasi)
  int topA; //pointer top untuk Stack A
  int topB; //pointer top untuk Stack B

  public SharedStack(int arraySize) {
    sharedArray = new int[arraySize]; //inisiasi array untuk sharing
    this.size = arraySize; 
    this.topA = 0; //Stack A dimulai dari index 0;
    this.topB = this.size - 1; //Stack B dimulai dari index (arraySize - 1)
  }

  public void pushA(int val) throws Exception {
    if (topA == topB) { //Jika topA (panjang Stack A) bertemu dengan pointer topB, maka array sharing sudah penuh
      throw new Exception("Stack A is overflowed");
    } else {
      sharedArray[topA++] = val; //Jika tidak, push ke Stack A seperti biasa
    }
  }

  public void pushB(int val) throws Exception {
    if (topB == topA) { //Jika topB (panjang Stack B) bertemu dengan pointer A, maka array sharing sudah penuh
      throw new Exception("Stack B is overflowed");
    } else { //Jika tidak, push ke Stack B dengan cara terbalik
      sharedArray[topB--] = val; //pointer topB mengecil ke arah tengah array
    }
  }

  public int popA() throws Exception {
    if (topA == 0) { //jika topA == 0, maka stack A kosong dan tidak bisa pop()
      throw new Exception("Stack A is underflowed");
    } else {
      int output = sharedArray[topA]; //jika tidak, pop() seperti biasa
      topA--;

      return output;
    }
  }

  public int popB() throws Exception {
    if (topB == sharedArray.length - 1) { //jika topB == arraySize - 1, maka stack B kosong
      throw new Exception("Stack B is underflowed");
    } else {
      int output = sharedArray[topB]; //Jika tidak, pop() dengan cara terbalik
      topB++; //index pointer topB naik

      return output;
    }
  }

  public void print() { //Fungsi pembantu untuk printing
    System.out.println("----------------------------");
    System.out.print("Stack A: ");
    for (int i = 0; i < topA; i++) { //Mencetak stackA dengan ascending for loop sampai batas topA
      if (i == topA - 1) {
        System.out.print(sharedArray[i]);
      } else {
        System.out.print(sharedArray[i] + " - ");
      }
    }
    
    System.out.println();

    System.out.print("Stack B: "); //Mencetak stackB dengan descending for loop sampai batas topB
    for (int i = this.size - 1; i > topB; i--) {
      if (i == topB + 1) {
        System.out.print(sharedArray[i]);
      } else {
        System.out.print(sharedArray[i] + " - ");
      }
    }
    System.out.println();
    System.out.println("----------------------------");
  }

  public static void main(String[] args) throws Exception {
    SharedStack stack = new SharedStack(20);
    stack.pushA(1);
    stack.pushA(2);
    stack.pushA(3);
    stack.pushA(4);
    stack.pushA(5);
    stack.print();

    stack.pushB(10);
    stack.pushB(9);
    stack.pushB(8);
    stack.pushB(7);
    stack.pushB(6);
    stack.print();

    stack.popA();
    stack.popB();
    stack.popB();
    stack.print();
  }
}
