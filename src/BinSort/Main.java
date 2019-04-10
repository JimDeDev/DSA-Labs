
package BinSort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;

/**
 *
 * @author gjr5542
 */
public class Main {

     private static final int LIST_SIZE = 20;



     public static void main(String[] args) {
          Random rand = new Random();

          int[] bins = new int[50];

          //Setting all bins to 0
          for (int i = 0; i < bins.length; i++) bins[i] = 0;

          //Preparing a list of random ints
          ArrayList<Integer> list = new ArrayList<>();
          for (int i = 0; i < LIST_SIZE; i++) {
               list.add(rand.nextInt(50));
          }

          System.out.println("List before sort:");
          System.out.println(list);

          for (Integer integer : list) {
               bins[integer]++;
          }

          list.clear();

          for (int i = 0; i < bins.length; i++) {
               while (bins[i] > 0) {
                    list.add(i);
                    bins[i]--;
               }
          }
          System.out.println("List after sort:");
          System.out.println(list);
     }

}

