package PriorityQueue;

public class Task<E extends Comparable> implements Comparable<Task <E>> {

    private E element;
    private int priority;

    public Task(E element, int priority) {
        this.element = element;
        this.priority = priority;
    }

    public E getElement() {
        return element;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public int compareTo(Task<E> o) {
        return this.priority - o.getPriority();
    }

    @Override
    public String toString() {
        return this.priority + " - " + this.element;
    }
}
