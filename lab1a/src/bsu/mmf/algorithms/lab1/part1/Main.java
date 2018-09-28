package bsu.mmf.algorithms.lab1.part1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Array.createArray();
        int[][] a = Array.fillArrays();
        Algorithms al = new Algorithms();
        long start0 = System.nanoTime();
        for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
            al.mergeSort(a[i], 0, Variables.ARRAY_LENGTH - 1);
        }
        long finish0 = (System.nanoTime() - start0);
        System.out.println("Мердж: " + finish0 + " наносекунды");
        while (Variables.n > 6) {
            int[][] array = Array.fillArrays();
            long start = System.nanoTime();
            for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
                al.hybridSort(array[i], 0, Variables.ARRAY_LENGTH - 1);
            }
            long finish = (System.nanoTime() - start);
            if (finish < finish0) {
                System.out.println("Гибрид быстрее на: " + (finish0 - finish) + " наносекунды " + Variables.n);
            } else {
                System.out.println(Variables.n);
            }
            Variables.n--;
        }
    }
}
