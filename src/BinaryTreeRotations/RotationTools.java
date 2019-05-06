package BinaryTreeRotations;

public class RotationTools {

    public static void rotateLeft(BinarySearchTree.BinaryTreeNode node) {

        System.out.println("Element: " + node.element);
        System.out.println("Left child: " + node.leftChild.element);
        System.out.println("Right child: " + node.rightChild.element);

        if (node.parent != null){
            BinarySearchTree.BinaryTreeNode parentNode = node.parent;
            if (parentNode.rightChild.equals(node)) {
                parentNode.rightChild = node.rightChild;
            } else {
                parentNode.leftChild = node.rightChild;
            }
        }



    }
}