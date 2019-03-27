/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ArrayStack;

import LinkedSortedSet.LinkedSortedSet;

/**
 *
 * @author gjr5542
 */
public class Main {
    
        public static void main(String[] args) {

            InefficientStack<String> stack = new InefficientStack<>();

            stack.push("Jaime");
            stack.push("Matt");
            stack.push("Cindy");
            System.out.println("Current stack: " + stack.toString());

            System.out.println("Pop: " + stack.pop());

            System.out.println("Peek: " + stack.peek());

            System.out.println("Pop: " + stack.pop());

            System.out.println("Current stack: " + stack.toString());

        }
}
