/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CircularArrayQueue;

import LinkedSortedSet.LinkedSortedSet;

/**
 *
 * @author gjr5542
 */
public class Main {
    
        public static void main(String[] args) {

           ArrayQueue<String> queue = new ArrayQueue<String>();

            queue.enqueue("Jim");
            queue.enqueue("Mat");
            queue.enqueue("Bob");

            System.out.println(queue.dequeue());
            System.out.println(queue.toString());

            queue.enqueue("Sal");
            queue.enqueue("Jef");
            queue.enqueue("Sue");
            System.out.println(queue.toString());

            System.out.println(queue.dequeue());
            System.out.println(queue.toString());

            System.out.println(queue.dequeue());
            System.out.println(queue.toString());
        }
}
