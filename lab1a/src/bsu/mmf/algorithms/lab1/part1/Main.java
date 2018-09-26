package bsu.mmf.algorithms.lab1.part1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Array.createArray();
        while (Variables.n > 6) {
            int[][] array = Array.fillArrays();
            long start = System.nanoTime();
            for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
                Algorithms.mergeSort(array[i], 0, array[i].length - 1);
            }
            long finish = (System.nanoTime() - start);
            System.out.println(Variables.n + "  " + finish + " наносекунды");
            Variables.n--;
        }
    }
}
