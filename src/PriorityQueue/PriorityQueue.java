package PriorityQueue;

public class PriorityQueue<E> {

    private ArrayHeap<Task <?>> queue;

    public PriorityQueue() {
        this.queue = new ArrayHeap();
    }

    public void enqueue(Task<?> task) {
        queue.add(task);
    }

    public Task<?> dequeue() {
        return queue.removeMin();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
