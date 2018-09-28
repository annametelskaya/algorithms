package bsu.mmf.algorithms.lab2a;

public class Sort {
    void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void quickSort(int[] array, int left, int right) {
        if (left < right) {
            int q = findQ(array, left, right);
            quickSort(array, left, q - 1);
            quickSort(array, q + 1, right);
        }
    }

    int findQ(int[] array, int left, int right) {
        int i = left + 1;
        int p = array[left];
        for (int j = left + 1; j <= right; j++) {
            if (array[j] < p) {
                swap(array, i, j);
                i += 1;
            }
        }
        swap(array, i - 1, left);
        return i - 1;
    }
}
