package PriorityQueue;

/**
 *
 * @author Jaime King
 */
public class Main {
    
    public static void main(String[] args) {
        PriorityQueue tasks = new PriorityQueue();

        tasks.enqueue(new Task("eat", 1));
        tasks.enqueue(new Task("sleep", 10));
        tasks.enqueue(new Task("read", 6));
        tasks.enqueue(new Task("sleep more", 10));
        tasks.enqueue(new Task("code", 2));
        tasks.enqueue(new Task("wash up", 9));

        while(!tasks.isEmpty()) {
            System.out.println(tasks.dequeue());
        }
    }
}
