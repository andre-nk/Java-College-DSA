public class TestBinarySearchTree {

  public static void main(String[] args) {
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(5);
    bst.insert(3);
    bst.insert(8);
    bst.insert(2);
    bst.insert(4);
    bst.insert(6);
    bst.insert(7);
    System.out.println(bst);

    bst.search(2);
    bst.search(9);

    bst.delete(8);
    System.out.println(bst);
    bst.delete(6);
    System.out.println(bst);
    bst.delete(7);
    System.out.println(bst);
    bst.delete(2);
    System.out.println(bst);
  }
}
