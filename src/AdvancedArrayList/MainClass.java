/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedArrayList;

/**
 *
 * @author gjr5542
 */
public class MainClass {
    
        public static void main(String[] args) {
            
            AdvancedArrayList<Integer> numbers = new AdvancedArrayList<Integer>();
            
            for(int i = 0; i < 10; i++) {
                numbers.add(i + 1);
            }
            numbers.printAll();
            
            System.out.println(numbers.getRandom());
            
            numbers.removeRandom();
            
            numbers.printAll();
    }
        
}
