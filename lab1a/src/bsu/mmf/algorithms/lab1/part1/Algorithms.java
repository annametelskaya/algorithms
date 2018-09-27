package bsu.mmf.algorithms.lab1.part1;

public class Algorithms {
    public static void mergeSort(int[] array, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int middleIndex = (rightIndex + leftIndex) / 2;
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    public static void hybridSort(int[] array, int leftIndex, int rightIndex) {
        if ((rightIndex - leftIndex) > Variables.n) {
            if (leftIndex < rightIndex) {
                int middleIndex = (rightIndex + leftIndex) / 2;
                hybridSort(array, leftIndex, middleIndex);
                hybridSort(array, middleIndex + 1, rightIndex);
                merge(array, leftIndex, middleIndex, rightIndex);
            }
        } else {
            insertionSort(array, leftIndex, rightIndex + 1);
        }
    }

    public static void merge(int[] array, int left, int middle, int right) {
        int leftLength = middle - left + 1;
        int rightLength = right - middle;
        int[] leftArray = new int[leftLength + 1];
        int[] rightArray = new int[rightLength + 1];
        for (int i = 0; i < leftLength; ++i) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightLength; ++i) {
            rightArray[i] = array[middle + i + 1];
        }
        leftArray[leftLength] = (int) Double.POSITIVE_INFINITY;
        rightArray[rightLength] = (int) Double.POSITIVE_INFINITY;
        int i = 0, j = 0;
        for (int k = left; k <= right; ++k) {
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                ++i;
            } else {
                array[k] = rightArray[j];
                ++j;
            }
        }
    }

    public static void insertionSort(int[] array, int left, int right) {
        int current, j;

        for (int i = left + 1; i < right - left; ++i) {
            current = array[i];
            j = i - 1;

            while (j >= left && array[j] > current) {
                array[j + 1] = array[j];
                --j;
            }

            array[j + 1] = current;
        }
    }
}

