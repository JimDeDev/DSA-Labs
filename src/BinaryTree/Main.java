
package BinaryTree;

import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author gjr5542
 */
public class Main {

     public static void main(String[] args) {

          MutableTreeNode root = new LinkedBinaryTreeNode<String>("A");
          MutableTreeNode nodeB = new LinkedBinaryTreeNode<String>("B");
          MutableTreeNode nodeC = new LinkedBinaryTreeNode<String>("C");
          MutableTreeNode nodeD = new LinkedBinaryTreeNode<String>("D");
          MutableTreeNode nodeE = new LinkedBinaryTreeNode<String>("E");
          MutableTreeNode nodeF = new LinkedBinaryTreeNode<String>("F");

          root.insert(nodeB, 0);
          root.insert(nodeC, 1);

          System.out.println(root);


     }

}

