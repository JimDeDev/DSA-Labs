/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedArrayList;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 *
 * @author gjr5542
 */
public class AdvancedArrayList<E> extends ArrayList<E> implements RandomObtainable {

    Random rand;
    
    public AdvancedArrayList(){
        super();
        this.rand = new Random(System.currentTimeMillis());

    }
    
    @Override
    public Object getRandom() throws NoSuchElementException {
        if(this.size() < 1) {
            throw new NoSuchElementException();
        }
        return this.get(rand.nextInt(this.size()));
    }

    @Override
    public boolean removeRandom() throws UnsupportedOperationException {
        if(this.size() < 1) {
            throw new UnsupportedOperationException();
        }
        this.remove(rand.nextInt(this.size()));

        return true;
    }
    
    public void printAll() {
        this.forEach((i) -> {
            System.out.print(i + ", ");
        });
        System.out.println("\n");
    }
}
