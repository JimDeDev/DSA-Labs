package BinaryTreeRotations;

import javax.swing.*;
import java.awt.*;
import java.util.SortedSet;

public class Main {

    public static void main(String[] args) {

        // create the binary search tree
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        // build the tree
        tree.add("cow");tree.add("fly");tree.add("dog");tree.add("bat");
        tree.add("fox");tree.add("cat");tree.add("eel");tree.add("ant");
        System.out.println("Original Tree: " + tree);
        tree.remove("owl");
        tree.remove("cow");
        tree.add("owl");


        JFrame frame = new JFrame("Jaime's Rotations");
        // kill all threads when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new TreeViewerGUI(tree));
        frame.setResizable(false);
        frame.pack();

        // position the frame in the middle of the screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();

        frame.setLocation((screenDimension.width-frameDimension.width)/2, (screenDimension.height-frameDimension.height)/2);

        frame.setVisible(true);
    }
}
