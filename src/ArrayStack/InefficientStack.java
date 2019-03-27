package ArrayStack;

import java.util.NoSuchElementException;

public class InefficientStack<E> implements StackADT<E>{

    private final int INITIAL_SIZE = 20;
    private E[] stack;
    private int numElements;

    public InefficientStack() {
        stack = (E[]) (new Object[INITIAL_SIZE]);
        numElements = 0;
    }

    @Override
    public void push(E element) {
        if (!isEmpty()) {
            shiftRight();
        }
        numElements++;
        stack[0] = element;
    }

    private void shiftRight() {
        if(numElements >= stack.length) grow();
        for (int i = numElements; i > 0; i--) {
            stack[i] = stack[i - 1];
        }
        stack[0] = null;
    }

    private void grow() {
        E[] newArray = (E[]) (new Object[stack.length * 2]);

        System.arraycopy(stack, 0, newArray, 0, numElements );

        stack = newArray;
    }

    @Override
    public E pop() throws NoSuchElementException {
        if (isEmpty()) throw new NoSuchElementException("Stack Empty");
        E element = stack[0];
        shiftLeft();
        numElements--;
        return element;
    }

    private void shiftLeft() {
        for (int i = 0; i < numElements; i++) {
            stack[i] = stack[i + 1];
        }
        stack[numElements - 1] = null;
    }

    @Override
    public E peek() throws NoSuchElementException {
        return stack[0];
    }

    @Override
    public boolean isEmpty() {
        return (numElements == 0);
    }

    @Override
    public int size() {
        return numElements;
    }

    public String toString() {
        String output = "";

        for (int i = 0; i < numElements; i++ ) {
            output += stack[i];
            if (i < numElements - 1) output += ", ";
        }
        return output;
    }
}
