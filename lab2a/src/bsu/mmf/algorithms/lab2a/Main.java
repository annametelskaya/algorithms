package bsu.mmf.algorithms.lab2a;

public class Main {
    public static void main(String[] args) {
        Sort q = new Sort();
        Search s = new Search();
        for (int i = 1; i < 20; i++) {
            int[] arr = new int[i + 1];
            Array.fillArray(arr, i + 1);
            //Array.printArray(arr);
            q.quickSort(arr, 0, arr.length - 1);
            //Array.printArray(arr);
            long start0 = System.nanoTime();
            int x = s.binarySearch(arr, 1);
            long finish0 = System.nanoTime() - start0;
            long start1 = System.nanoTime();
            x = s.interpolationSearch(arr, 1);
            long finish1 = System.nanoTime() - start1;
            if (finish0 < finish1) {
                System.out.println("На массиве размером:" + (i + 1));
                System.out.println("Бинарный поиск(" + finish0 + ") быстрее чем интерполяуионный (" + finish1 + ")");
                break;
            }
        }
    }
}
