public class BinarySearchTree {

  private BinarySearchNode root;

  BinarySearchTree() {
    root = null;
  }

  public void insert(Integer data) {
    BinarySearchNode p = root;
    BinarySearchNode parent = null;
    boolean isLeftChild = false; //True jika p adalah left child dari parent x

    while (p != null) {
      int result = data.compareTo(p.data);
      if (result == 0) {
        System.out.println(data + "already exist");
        return; //stop insertion since data is exist
      } else if (result < 0) { //data < p.data
        parent = p;
        isLeftChild = true;
        p = p.left; //shift left
      } else { //data > p.data
        parent = p;
        isLeftChild = false;
        p = p.right; //shift right
      }
    }

    BinarySearchNode newNode = new BinarySearchNode(data);
    if (parent == null) {
      root = newNode;
    } else if (isLeftChild) {
      parent.left = newNode; //create branch
    } else {
      parent.right = newNode;
    }
  }

  public void search(Integer data) {
    BinarySearchNode p = root;

    while (p != null) {
      int result = data.compareTo(p.data);
      if (result == 0) {
        System.out.println(data + " is found");
        return;
      } else if (result < 0) {
        p = p.left;
      } else {
        p = p.right;
      }
    }

    System.out.println(data + " is not found");
  }

  public void delete(Integer data) {
    BinarySearchNode p = root;
    BinarySearchNode parent = null;
    boolean isLeftChild = false;

    while (p != null) {
      int result = data.compareTo(p.data);
      if (result == 0) { // data is found
        if (p.left == null && p.right == null) { // external
          if (parent == null) {
            root = null; // delete root (the only node in BST)
          } else if (isLeftChild) {
            parent.left = null; // delete left child of parent x
          } else {
            parent.right = null;
          }
        } else if (p.left == null) { // Parent X only has right node
          if (parent == null) {
            root = p.right;
          } else if (isLeftChild) {
            parent.left = p.right;
          } else {
            parent.right = p.right;
          }
        } else if (p.right == null) {
          if (parent == null) {
            root = p.left;
          } else if (isLeftChild) {
            parent.left = p.left;
          } else {
            parent.right = p.left;
          }
        } else {
          BinarySearchNode x = findMin(p);
          if (parent == null) {
            root = x;
          } else if (isLeftChild) {
            parent.left = x;
          } else {
            parent.right = x;
          }

          x.right = p.right;
          x.left = p.left;
        }

        System.out.println(data + " is deleted");
        return;
      } else if (result < 0) {
        parent = p;
        isLeftChild = true;
        p = p.left;
      } else {
        parent = p;
        isLeftChild = false;
        p = p.right;
      }
    }

    System.out.println(data + " is not found");
  }

  public String toString() {
    return inorder(root);
  }

  private BinarySearchNode findMin(BinarySearchNode parent) {
    BinarySearchNode p = parent.right;
    while (p.left != null) {
      p = p.left;
    }

    return p;
  }

  private String inorder(BinarySearchNode p) {
    if (p == null) {
      return "";
    }

    return inorder(p.left) + " " + p.data + " " + inorder(p.right);
  }
}
