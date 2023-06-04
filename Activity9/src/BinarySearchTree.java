import java.util.ArrayList;
import java.util.List;

class TreePrinter {

  public void print(BinarySearchNode root) {
    List<List<String>> lines = new ArrayList<>(); // List to store the lines of the tree

    List<BinarySearchNode> level = new ArrayList<>(); // Nodes at the current level
    List<BinarySearchNode> next = new ArrayList<>(); // Nodes at the next level

    level.add(root); // Add the root node to the current level
    int nn = 1; // Number of nodes at the current level

    int widest = 0; // Widest label of the nodes

    while (nn != 0) {
      List<String> line = new ArrayList<>(); // Line at the current level

      nn = 0; // Reset the number of nodes at the next level

      for (BinarySearchNode n : level) {
        if (n == null) {
          line.add(null); // Add null to the line if the node is empty

          next.add(null);
          next.add(null);
        } else {
          String aa = String.valueOf(n.data);
          line.add(aa); // Add the label of the node to the line
          if (aa.length() > widest) widest = aa.length(); // Update the widest label

          next.add(n.left);
          next.add(n.right);

          if (n.left != null) nn++; // Count the number of nodes at the next level
          if (n.right != null) nn++;
        }
      }

      lines.add(line); // Add the line to the list of lines

      List<BinarySearchNode> tmp = level;
      level = next;
      next = tmp;
      next.clear();
    }

    int perpiece = lines.get(lines.size() - 1).size() * (widest + 1); // Number of characters per piece of each node on a specific line
    for (int i = 0; i < lines.size(); i++) {
      List<String> line = lines.get(i); // Get the line at a specific level
      int hpw = (int) Math.floor(perpiece / 2f) - 1; // Number of characters in half a piece per node on a specific line

      if (i > 0) {
        for (int j = 0; j < line.size(); j++) {
          // Divide the node
          char c = ' ';
          if (j % 2 == 1) {
            if (line.get(j - 1) != null) {
              c = (line.get(j) != null) ? '┴' : '┘'; // Divider symbol if the node has a left child or not
            } else {
              if (j < line.size() && line.get(j) != null) c = '└'; // Divider symbol if the node doesn't have a left child
            }
          }
          System.out.print(c);

          // Lines and spaces
          if (line.get(j) == null) {
            for (int k = 0; k < perpiece - 1; k++) {
              System.out.print(" ");
            }
          } else {
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? " " : "-"); // Line symbol around the node
            }
            System.out.print(j % 2 == 0 ? "┌" : "┐"); // Divider symbol above the node
            for (int k = 0; k < hpw; k++) {
              System.out.print(j % 2 == 0 ? "-" : " "); // Line symbol around the node
            }
          }
        }
        System.out.println();
      }

      for (int j = 0; j < line.size(); j++) {
        String f = line.get(j);
        if (f == null) f = "";
        int gap1 = (int) Math.ceil(perpiece / 2f - f.length() / 2f); // Gap on the left of the number
        int gap2 = (int) Math.floor(perpiece / 2f - f.length() / 2f); // Gap on the right of the number

        for (int k = 0; k < gap1; k++) {
          System.out.print(" ");
        }
        System.out.print(f);
        for (int k = 0; k < gap2; k++) {
          System.out.print(" ");
        }
      }
      System.out.println();

      perpiece /= 2; // Update the number of characters per piece for the next line
    }
  }
}

public class BinarySearchTree {

  private BinarySearchNode root;
  private TreePrinter treePrinter;

  BinarySearchTree() {
    root = null;
    treePrinter = new TreePrinter();
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

    treePrinter.print(this.root);
    System.out.println("");
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
        treePrinter.print(this.root);
        System.out.println("");
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

  public String toInteger() {
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
