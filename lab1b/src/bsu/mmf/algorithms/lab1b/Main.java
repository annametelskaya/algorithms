package bsu.mmf.algorithms.lab1b;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[][] a1 = new String[][]{{"8", "7", "10", "2", "5"}, {"Anna", "Ira", "Veronika", "Ilya", "Andrew"}};
        String[][] a2 = new String[][]{{"Anna", "Ira", "Veronika", "Ilya", "Andrew"},{"first", "second", "third", "forth", "fifth"}};
        printArray(a1);
        printArray(a2);
        Algorithm.quickSort(a1[0], a1[1], a2[0], a2[1], 0, a1[0].length - 1);
        printArray(a1);
        printArray(a2);
    }

    public static void printArray(String[][] a) {
        for (int i = 0; i < a[0].length; i++) {
            System.out.print(a[0][i] + " " + a[1][i] + ", ");
        }
        System.out.println();
    }
}
