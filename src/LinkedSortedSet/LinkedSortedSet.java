package LinkedSortedSet;

import java.util.Iterator;

public class LinkedSortedSet<E extends Comparable<E>> extends LinkedSet<E>{

    public LinkedSortedSet() {
        super();

    }

    @Override
    public boolean add(E element) {

        if(element == null) return false;

        Node<E> newNode = new Node<E>(element);

        if(this.isEmpty()) {
            this.firstNode = newNode;
            this.numElements++;
            return true;
        } else if (newNode.element.compareTo(firstNode.element) < 0){
            newNode.next = firstNode;
            this.firstNode = newNode;
        } else {
            Node<E> currentNode = this.firstNode;

            while (currentNode != null) {
                if(newNode.element.compareTo(currentNode.element) > 0) {
                    if(currentNode.next != null) {
                        if (newNode.element.compareTo(currentNode.next.element) < 0) {
                            newNode.next = currentNode.next;
                            currentNode.next = newNode;
                            this.numElements++;
                            return true;
                        }
                        else if (newNode.element.compareTo(currentNode.next.element) == 0) {
                            return false;
                        }
                    }
                    else {
                        newNode.next = currentNode.next;
                        currentNode.next = newNode;
                        this.numElements++;
                        return true;
                    }
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public String toString() {
        String output = "";
        Iterator<E> it = this.iterator();
        while(it.hasNext()) {
            output += it.next();
            if(it.hasNext()) {
                output += ", ";
            }
        }
        return output;
    }
}
