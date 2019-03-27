package CircularArrayQueue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<E> implements QueueADT<E> {

    private final int INITIAL_SIZE = 20;
    private E[] queue;
    private int numElements;
    private int first, last;

    public ArrayQueue(){
        this.queue = (E[]) (new Object[INITIAL_SIZE]);
        first = -1;
        last = -1;
    }

    @Override
    public void enqueue(E element) {
        if (isEmpty()) {
            queue[0] = element;
            first = 0;
            last = 0;
        } else {
            if(numElements + 1 == queue.length) {
                this.grow();
            }
            if(last + 1 == queue.length) last = 0;
            queue[++last] = element;
        }
        numElements++;
    }

    private void grow() {
        E[] newArray = (E[]) (new Object[size() * 2]);
        Iterator<E> it = this.iterator();
        int i = 0;
        while (it.hasNext()) {
            newArray[i++] = it.next();
        }
        first = 0;
        last = size() -1;
        this.queue = newArray;
    }

    @Override
    public E dequeue() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException();

        //copying the data and setting the original to null
        E returnElement = queue[first];
        queue[first] = null;

        if(first == queue.length - 1) {
            first = 0;
        } else {
            first++;
        }
        numElements--;
        return returnElement;
    }

    @Override
    public E first() throws NoSuchElementException {
        if(isEmpty()) throw new NoSuchElementException();
        return queue[first];
    }

    @Override
    public boolean isEmpty() {
        return (size() == 0);
    }

    @Override
    public int size() {
        return numElements;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int i = first;

            @Override
            public boolean hasNext() {
                if (i == queue.length) return (queue[0] != null);

                if (queue[i] == null) {
                    return false;
                }
                return true;
            }

            @Override
            public E next() {
                if(i == queue.length) i = 0;
                return queue[i++];
            }
        };
    }

    public String toString() {
        String output = "";

        for (Iterator it = iterator(); it.hasNext();) {
            output += (it.next());
            if(it.hasNext()) output += ", ";
        }
        return output;
    }
}
