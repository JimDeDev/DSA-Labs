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
            if(numElements == queue.length) {
                this.grow();
            }
            last++;
            if(last == queue.length) last = 0;
            queue[last] = element;
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

        first++;
        if(first == queue.length) {
            first = 0;
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
            private int elementsPassed = 0;

            @Override
            public boolean hasNext() {
                return (elementsPassed < numElements);
            }

            @Override
            public E next() {
                if(i == queue.length) i = 0;
                elementsPassed++;
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
