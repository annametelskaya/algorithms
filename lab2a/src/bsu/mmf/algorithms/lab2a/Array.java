package bsu.mmf.algorithms.lab2a;

public class Array {
    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void fillArray(int [] arr, int n){
        for (int i=0;i<n; i++){
            arr[i]=(int)(Math.random()*10);
        }
    }
}
