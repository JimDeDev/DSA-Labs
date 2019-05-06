package BinaryTreeRotations;

import BinaryTreeRotations.BinarySearchTree;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class DrawPane extends JPanel {

    private BinarySearchTree tree;

    public DrawPane(BinarySearchTree tree) {
        this.tree = tree;

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        tree.drawTree(g, this.getWidth());

    }
}

