package CircularArrayQueue;

import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueADT<E> {

    private final int INITIAL_CAPACITY = 5;
    private E[] queue;
    private int numElements;
    private int qFront, qEnd;

    public ArrayQueue(){
        this.queue = (E[]) new Object[INITIAL_CAPACITY];
        this.numElements = 0;
        this.qEnd = 0;
        this.qFront = 0;
    }

    @Override
    public void enqueue(E element) {

        if(isEmpty()) {
            queue[0] = element;
            numElements++;
        } else {
            if(numElements == queue.length) {
                expand();
            }
            if(qEnd == queue.length - 1) {
                qEnd = -1;
            }
            queue[++qEnd] = element;
            numElements++;
        }
    }

    private void expand() {
        E[] newQueue = (E[]) new Object[queue.length * 2];

        int it = qFront;

        for(int i = 0; i < numElements; i++)


    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();
        E element = queue[qFront];
        queue[qFront] = null;
        qFront++;
        numElements--;
        return element;
    }

    @Override
    public E first() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();
        return queue[qFront];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return numElements;
    }

    public String toString() {
        String output = "";
        for(int i = 0; i < queue.length; i++) {

            output += queue[i] + ", ";

        }
        return output;
    }
}
