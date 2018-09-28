package bsu.mmf.algorithms.lab1.part1;

public class Algorithms {
    void mergeSort(int[] array, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = (rightIndex + leftIndex) / 2;
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);
            merge(array, leftIndex, middleIndex, rightIndex);
        }
    }

    void hybridSort(int[] array, int leftIndex, int rightIndex) {
        if ((rightIndex - leftIndex) > Variables.n) {
            if (leftIndex < rightIndex) {
                int middleIndex = (rightIndex + leftIndex) / 2;
                hybridSort(array, leftIndex, middleIndex);
                hybridSort(array, middleIndex + 1, rightIndex);
                merge(array, leftIndex, middleIndex, rightIndex);
            }
        } else {
            insertionSort(array, leftIndex, rightIndex);
        }
    }

    void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        int it1 = 0;
        int it2 = 0;
        int[] result = new int[rightIndex - leftIndex];

        while (leftIndex + it1 < middleIndex && middleIndex + it2 < rightIndex) {
            if (array[leftIndex + it1] < array[middleIndex + it2]) {
                result[it1 + it2] = array[leftIndex + it1];
                it1 += 1;
            } else {
                result[it1 + it2] = array[middleIndex + it2];
                it2 += 1;
            }
        }
        while (leftIndex + it1 < middleIndex) {
            result[it1 + it2] = array[leftIndex + it1];
            it1 += 1;
        }
        while (middleIndex + it2 < rightIndex) {
            result[it1 + it2] = array[middleIndex + it2];
            it2 += 1;
        }
        for (int i = 0; i < it1 + it2; i += 1) {
            array[leftIndex + i] = result[i];
        }
    }

    void insertionSort(int[] array, int left, int right) {
        for (int i = left; i < right; i++) {
            for (int j = i + 1; j > left; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }
}

