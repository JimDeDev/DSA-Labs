/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SelectionSort;

/**
 *
 * @author gjr5542
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] numbers = {5,4,3,2,1};

        System.out.println("unsorted");
        printArray(numbers);

        int[] sortedNumbers = sort(numbers);

        System.out.println("sorted");
        printArray(sortedNumbers);

    }

    private static int[] sort(int[] numbers) {
        int moves = 0;
        for( int i = 0; i < numbers.length - 1; i++) {
            int smallest = i;
            for( int j = i + 1; j < numbers.length; j++) {
                if (numbers[smallest] > numbers[j]) {
                    smallest = j;
                }
            }
            if (smallest != -1) {
                int temp = numbers[smallest];
                numbers[smallest] = numbers[i];
                numbers[i] = temp;
                moves++;
                //printArray(numbers);
            }
        }
        //System.out.println("\n\nMoves = " + moves);
        return numbers;
    }

    private static void printArray(int[] numbers) {
        for ( int aNumber : numbers) {
            System.out.print(aNumber + ", ");
        }
        System.out.println("\n");

    }
}