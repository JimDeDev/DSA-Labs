/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdvancedArrayList;

import java.util.NoSuchElementException;

/**
 *
 * @author gjr5542
 */
public interface RandomObtainable<E> {

    public E getRandom() throws NoSuchElementException;
    public boolean removeRandom() throws UnsupportedOperationException;

}