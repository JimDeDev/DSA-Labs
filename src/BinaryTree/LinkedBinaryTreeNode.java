package BinaryTree;

import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Enumeration;
import java.util.NoSuchElementException;

public class LinkedBinaryTreeNode<E> implements MutableTreeNode {

    private E element;
    private MutableTreeNode parent, leftChild, rightChild;

    public LinkedBinaryTreeNode(E element) {
        this.element = element;
        this.parent = null;
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        if (childIndex < 0 || childIndex > 1) throw new IllegalArgumentException();

        if (childIndex == 0) {
            return this.leftChild;
        } else {
            return this.rightChild;
        }
    }

    @Override
    public int getChildCount() {
        int numChildren = 0;
        if (this.leftChild != null) {
            numChildren++;
        }
        if (this.rightChild != null) {
            numChildren++;
        }
        return numChildren;
    }

    @Override
    public void insert(MutableTreeNode child, int index) {
        if (index < 0 || index > 1 || child == null) throw new IllegalArgumentException();

        if (index == 0) {
            if (this.leftChild != null) {
                this.leftChild.removeFromParent();
            }
            this.leftChild = child;
        } else {
            if (this.rightChild != null) {
                this.rightChild.removeFromParent();
            }
            this.rightChild = child;
        }
        child.setParent(this);
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index > 1) throw new IllegalArgumentException();

        if (index == 0) {
            if (this.leftChild != null) {
                this.leftChild.removeFromParent();
                this.leftChild = null;
            } else throw new NoSuchElementException();
        } else {
            if (this.rightChild != null) {
                this.rightChild.removeFromParent();
                this.rightChild = null;
            } else throw new NoSuchElementException();
        }
    }

    @Override
    public void removeFromParent() {
        this.parent = null;
    }

    @Override
    public void remove(MutableTreeNode node) throws NoSuchElementException, IllegalArgumentException{
        if (node == null) throw new IllegalArgumentException();

        if (this.leftChild == node) {
            this.remove(0);
        } else if (this.rightChild == node) {
            this.remove(1);
        } else throw new NoSuchElementException();
    }

    @Override
    public void setUserObject(Object object) {
        this.element = (E) object;
    }

    @Override
    public void setParent(MutableTreeNode newParent) {
        this.parent = newParent;
    }

    @Override
    public TreeNode getParent() {
        return this.parent;
    }

    @Override
    public int getIndex(TreeNode node) {
        if (node == null) throw new IllegalArgumentException();

        if (this.leftChild == node) {
            return 0;
        } else if (this.rightChild == node) {
            return 1;
        } else throw new NoSuchElementException();
    }

    @Override
    public boolean isLeaf() {
        return (this.getChildCount() == 0);
    }

    @Override
    public Enumeration children() {
        return null;
    }

    public String toString() {
        String output = "";

        output += "Element: " + this.element + "\n";
        output += "left Child: " + this.leftChild.toString();
        return output;
    }
}
