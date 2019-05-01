
package BinaryTree;

import javax.swing.tree.MutableTreeNode;

/**
 *
 * @author gjr5542
 */
public class Main {

     public static void main(String[] args) {

          LinkedBinaryTreeNode<String> root = new LinkedBinaryTreeNode<>("A");
          LinkedBinaryTreeNode<String> nodeB = new LinkedBinaryTreeNode<>("B");
          LinkedBinaryTreeNode<String> nodeC = new LinkedBinaryTreeNode<>("C");
          LinkedBinaryTreeNode<String> nodeD = new LinkedBinaryTreeNode<>("D");
          LinkedBinaryTreeNode<String> nodeE = new LinkedBinaryTreeNode<>("E");
          LinkedBinaryTreeNode<String> nodeF = new LinkedBinaryTreeNode<>("F");

          root.insert(nodeB, 0);
          root.insert(nodeC, 1);
          nodeB.insert(nodeD, 0);
          nodeB.insert(nodeE, 1);
          System.out.println(root);
          System.out.println(nodeB);


     }

}

