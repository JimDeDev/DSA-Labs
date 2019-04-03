
package BinarySearch;

import java.util.LinkedList;
import java.util.ListIterator;

/**
 *
 * @author gjr5542
 */
public class Main {

     private static LinkedList<Integer> array;

     public static void main(String[] args) {

          array = new LinkedList<>();

          for (int i = 0; i < 50; i += 5) {
               array.add(i);
          }

          System.out.println(array);

          int target = 30;

          int targetIndex = search(target, 0, array.size());

          System.out.print("Found " + target + " at index " + targetIndex);

     }

     private static int search(Integer target, int start, int end) {

          if (start > end) {
               return -start-1;
          }

          ListIterator li = array.listIterator();
          int middle = (start + end ) / 2;
          Integer middleElement = -1;
          for(int i = 0; i <= middle; i++) {
               middleElement = (Integer) li.next();
          }

          if (target.compareTo(middleElement) == 0) {
               return middle;
          }
          else if(target.compareTo(middleElement) < 0 ) {
               return search(target, start, middle);
          }
          else {
               return search(target, middle + 1, end);
          }
     }
}
