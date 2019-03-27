
package CircularArrayQueue;

/**
 *
 * @author gjr5542
 */
public class Main {
    
     public static void main(String[] args) {

         ArrayQueue<String> queue = new ArrayQueue<>();

         queue.enqueue("Jim");
         queue.enqueue("Mat");
         queue.enqueue("Bob");
         System.out.println("Added Jim, Mat, Bob");
         System.out.println("Current Queue: " + queue.toString());

         System.out.println("Dequeue: " + queue.dequeue());
         System.out.println(queue.toString());

         queue.enqueue("Sal");
         queue.enqueue("Jef");
         queue.enqueue("Sue");
         System.out.println("Added Sal, Jef, Sue");
         System.out.println("Current Queue: " + queue.toString());

         System.out.println("Dequeue: " + queue.dequeue());
         System.out.println("Current Queue: " + queue.toString());

         System.out.println("Dequeue: " + queue.dequeue());
         System.out.println("Current Queue: " + queue.toString());
     }
}
