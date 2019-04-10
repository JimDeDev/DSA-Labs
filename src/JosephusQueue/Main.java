
package JosephusQueue;

import CircularArrayQueue.ArrayQueue;

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
          queue.enqueue("Sal");
          queue.enqueue("Jef");
          queue.enqueue("Sue");
          queue.enqueue("Bry");
          queue.enqueue("Mik");
          queue.enqueue("Jon");
          queue.enqueue("Han");
          queue.enqueue("Zeb");

          int n = 3;

          while (!queue.isEmpty()) {

               System.out.println(queue);

               for (int i = 0; i < n; i++) {
                    if (i < n - 1) {
                         queue.enqueue(queue.dequeue());
                    } else {
                         System.out.println("Killing:  " + queue.dequeue());
                    }
               }
          }
     }
}
