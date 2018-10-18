package bsu.mmf.algorithms.lab3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static void createArray() throws IOException {
        String filePath = "/home/anna/Desktop/algorithms/lab3/src/array.txt";
        BufferedWriter out = new BufferedWriter(new FileWriter(filePath));
        for (int j = 0; j < Variables.NUMBER_OF_ARRAYS; j++) {
            for (int i = 0; i < Variables.ARRAY_SIZE; i++) {
                int number = (int) (Math.random() * Variables.ARRAY_SIZE);
                out.write(number + " ");
            }
        }
        out.close();
    }

    private static int[][] fillArrays() throws IOException {
        File file = new File("/home/anna/Desktop/algorithms/lab3/src/array.txt");
        int[][] array = new int[Variables.NUMBER_OF_ARRAYS][Variables.ARRAY_SIZE];
        Scanner in = new Scanner(file);
        for (int j = 0; j < Variables.NUMBER_OF_ARRAYS; j++) {
            for (int i = 0; i < Variables.ARRAY_SIZE; i++) {
                array[j][i] = in.nextInt();
            }
        }
        in.close();
        return array;
    }

    private static void findAvgLenght(int array[][], double A) {
        int sum = 0;
        for (int i = 0; i < Variables.NUMBER_OF_ARRAYS; i++) {
            HashTable table = new HashTable(A);
            table.insert(array[i]);
            sum += table.findMaxChain();
        }
        System.out.println("A=" + A + ", length=" + sum / 50 + ", sum=" + sum);
    }

    public static void main(String[] args) throws IOException {
        //Array.createArray();
        int[][] array = fillArrays();
        findAvgLenght(array,Variables.A);
        findAvgLenght(array,Variables.A1);
        findAvgLenght(array,Variables.A2);
        findAvgLenght(array,Variables.A3);
    }
}
