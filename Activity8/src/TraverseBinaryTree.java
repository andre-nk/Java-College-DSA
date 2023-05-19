public class TraverseBinaryTree {
  public static void traversePreorder(BinaryTreeNode t) {
    if (t == null) return;
    System.out.println("Visited node: " + t.label);
    traversePreorder(t.left);
    traversePreorder(t.right);
  }

  public static void traverseInorder(BinaryTreeNode t) {
    if (t == null) return;
    traverseInorder(t.left);
    System.out.println("Visited node: " + t.label);
    traverseInorder(t.right);
  }

  public static void traversePostorder(BinaryTreeNode t) {
    if (t == null) return;
    traversePostorder(t.left);
    traversePostorder(t.right);
    System.out.println("Visited node: " + t.label);
  }

  public static void main(String[] args) {
    BinaryTreeNode tree, p, q;
    p = new BinaryTreeNode("c", null, null);
    p = new BinaryTreeNode("b", p, null);
    q = new BinaryTreeNode("d", null, null);
    tree = new BinaryTreeNode("a", p, q);

    System.out.println(tree);

    System.out.println("Preorder traversal");
    traversePreorder(tree);

    System.out.println("Inorder traversal:");
    traverseInorder(tree);

    System.out.println("Postorder traversal");
    traversePostorder(tree);
  }
}
