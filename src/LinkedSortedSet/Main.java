/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LinkedSortedSet;

import AdvancedArrayList.AdvancedArrayList;

/**
 *
 * @author gjr5542
 */
public class Main {
    
        public static void main(String[] args) {

            LinkedSortedSet<Integer> numbers = new LinkedSortedSet<Integer>();

            numbers.add(2);
            numbers.add(1);
            numbers.add(3);
            numbers.add(0);
            numbers.add(3);
            numbers.add(12);
            numbers.add(10);
            numbers.add(-5);
            numbers.add(null);
            numbers.add(0);


            System.out.println(numbers.toString());

        }
}
