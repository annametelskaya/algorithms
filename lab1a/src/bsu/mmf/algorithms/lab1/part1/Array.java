package bsu.mmf.algorithms.lab1.part1;

import java.io.*;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Array {

    public static void createArray() throws IOException {
        String filePath = "src\\array.txt";
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        for (int j = 0; j < Variables.NUMBER_OF_ARRAYS; j++) {
            for (int i = 0; i < Variables.ARRAY_LENGTH; i++) {
                int number = (int) (Math.random() * Variables.NUMBER_TO);
                out.write(number + " ");
            }
        }
        out.close();
    }

    public static int[][] fillArrays() throws IOException {
        File file = new File( "src\\array.txt");
        int[][] array = new int[Variables.NUMBER_OF_ARRAYS][Variables.ARRAY_LENGTH];
        Scanner in = new Scanner(file);
        for (int j = 0; j < Variables.NUMBER_OF_ARRAYS; j++) {
            for (int i = 0; i < Variables.ARRAY_LENGTH; i++) {
                array[j][i] = in.nextInt();
            }
        }
        in.close();
        return array;
    }

    public static void sortArray() throws IOException {
        //createArray();
        int[][] array = Array.fillArrays();
        long start = System.nanoTime();
        for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
            Algorithms.mergeSort(array[i], 0, array[i].length - 1);
            //Algorithms.insertionSort(array[i]);
        }
        long finish = System.nanoTime() - start;
        System.out.println( finish + "\n" + TimeUnit.SECONDS.convert(finish, TimeUnit.NANOSECONDS));
    }
}
