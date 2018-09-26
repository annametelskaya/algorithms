package bsu.mmf.algorithms.lab1b;

public class Algorithm {
    public static void swap(String[]arr,int i, int j){
        String temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void quickSort(String[] array, String[] arr, String[] sarray, String[] sarr, int left, int right) {
        if (left < right) {
            int q = findQ(array, arr, sarray, sarr, left, right);
            quickSort(array, arr, sarray, sarr, left, q - 1);
            quickSort(array, arr, sarray, sarr, q + 1, right);
        }
    }

    private static int findQ(String[] array, String[] arr, String[] sarray, String[] sarr, int left, int right) {
        int i=left+1;
        String p=array[left];
        for (int j=left+1; j<=right; j++){
            if (Integer.decode(array[j])<Integer.decode(p)){
                swap(array,i,j);
                swap(arr,i,j);
                swap(sarray,i,j);
                swap(sarr,i,j);
                i+=1;
            }
        }
        swap(array,i-1,left);
        swap(sarray,i-1,left);
        swap(arr,i-1,left);
        swap(sarr,i-1,left);
        return i-1;
    }
}