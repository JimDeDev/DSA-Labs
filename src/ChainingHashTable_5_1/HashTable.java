package ChainingHashTable_5_1;

public class HashTable<E> {

    private int INITIAL_CAPACITY = 10;
    private Node<E>[] table;
    private int numElements;

    public HashTable() {
        this.table = new Node[INITIAL_CAPACITY];
        this.numElements = 0;
    }

    public void add(E element) {
        Node aNode = new Node(element);

        if (numElements > table.length * 0.75) {
            expand();
        }

        int index = element.hashCode() % table.length;

        if (table[index] != null) {
            aNode.nextNode = table[index];
        }
        this.table[index] = aNode;
        numElements++;
    }

    public boolean remove(E element) {

        int index = element.hashCode() % table.length;

        if (table[index] != null) {
            Node aNode = table[index];
            if (aNode.element == element){
                table[index] = aNode.nextNode;
                numElements--;
                return true;
            }

            while (aNode.nextNode != null) {
                if (aNode.nextNode.element == element) {
                    aNode.nextNode = aNode.nextNode.nextNode;
                    numElements--;
                    return true;
                }
                aNode = aNode.nextNode;
            }
        }
        return false;
    }

    public boolean contains(E element) {
        int index = element.hashCode() % table.length;

        if (table[index] != null) {
            Node aNode = table[index];

            while (aNode != null) {
                if (aNode.element == element) {
                    return true;
                }
                aNode = aNode.nextNode;
            }
        }
        return false;
    }

    private void expand() {
        System.out.println("WE WILL EXPAND");

        Node<E>[] temp = table;
        numElements = 0;

        this.table = new Node[this.table.length * 2];

        for (int i = 0; i < temp.length; i++) {

            if (temp[i] != null) {
                Node aNode = temp[i];

                while (aNode != null) {
                    this.add((E) aNode.element);
                    aNode = aNode.nextNode;
                }
            }
        }
    }

    public String toString() {
        String output = "";

        for (int i = 0; i < table.length; i++) {

            output = output.concat("Row " + i + ":");
            if (table[i] != null) {
                Node aNode = table[i];

                while (aNode != null) {
                    output = output.concat(" | " + aNode.element.toString());
                    aNode = aNode.nextNode;
                }
            }
            output = output.concat("\n");
        }

        return output;
    }

    private class Node<E> {

        E element;
        Node<E> nextNode;

        public Node(E element) {
            this.element = element;
            this.nextNode = null;
        }

    }

}
