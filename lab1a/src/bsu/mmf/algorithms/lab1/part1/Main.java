package bsu.mmf.algorithms.lab1.part1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Array.createArray();
        int[][] a = Array.fillArrays();
        long start0 = System.nanoTime();
        for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
            Algorithms.mergeSort(a[i], 0, a[i].length - 1);
        }
        long finish0 = (System.nanoTime() - start0);
        System.out.println(finish0 + " наносекунды");
        while (Variables.n > 6) {
            int[][] array = Array.fillArrays();
            long start = System.nanoTime();
            for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
                Algorithms.hybridSort(array[i], 0, array[i].length - 1);
            }
            long finish = (System.nanoTime() - start);
            if (finish < finish0) {
                System.out.println(finish + " наносекунды " + Variables.n);
            }
            Variables.n--;
        }
    }
}
