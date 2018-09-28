package bsu.mmf.algorithms.lab2a;

public class Main {
    public static void main(String[] args) {
        Sort q = new Sort();
        Search s = new Search();
        int[] arr = new int[]{78, 546, 684, 647, 47687, 53, 548, 7, 34, 68, 3, 0, 8654, 687, 64, 87663, 6};
        Array.printArray(arr);
        q.quickSort(arr, 0, arr.length - 1);
        Array.printArray(arr);
        int x = s.binarySearch(arr, 0, arr.length - 1, 53);
        System.out.println(x);
        x = s.interpolationSearch(arr, 0, arr.length - 1, 53);
        System.out.println(x);
    }
}
