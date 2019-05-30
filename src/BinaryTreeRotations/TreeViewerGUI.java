package BinaryTreeRotations;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TreeViewerGUI extends JPanel implements ActionListener {

    private BinarySearchTree tree;
    private JPanel menu;
    private DrawPane drawPane;
    private JButton rotateLeft;

    public TreeViewerGUI(BinarySearchTree tree) {
        super(new BorderLayout());

        this.tree = tree;
        this.drawPane = new DrawPane(tree);

        setPreferredSize(new Dimension(700, 600));

        this.add(drawPane, BorderLayout.CENTER);

        this.menu = new JPanel();
        menu.setBackground(new Color(220, 220, 220));

        this.rotateLeft = new JButton("Rotate Left");
        this.rotateLeft.addActionListener(this);
        this.rotateLeft.setBackground(null);
        this.menu.add(this.rotateLeft);

        this.add(menu, BorderLayout.SOUTH);

        Timer timer = new Timer(10, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == rotateLeft) {
            System.out.println("rotateLeft called");

            String value = JOptionPane.showInputDialog("Left Rotate about which node?","cow");

            if (tree.contains(value)) {
                RotationTools.rotateLeft(tree.getNodeByValue(value));
            } else {
                JOptionPane.showMessageDialog(this, "Node does not exist");
            }


        }
        drawPane.repaint();
    }
}
