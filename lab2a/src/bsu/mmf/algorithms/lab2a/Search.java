package bsu.mmf.algorithms.lab2a;

public class Search {
    int binarySearch(int arr[], int left, int right, int x) {
        if (right >= left) {
            int p = left + (right - left) / 2;
            if (arr[p] == x)
                return p;
            if (arr[p] > x)
                return binarySearch(arr, left, p - 1, x);
            return binarySearch(arr, p + 1, right, x);
        }
        return -1;
    }

    int interpolationSearch(int[] arr, int left, int right, int x) {
        while (left <= right && x >= arr[left] && x <= arr[right]) {
            int p = left + (((right - left) /
                    (arr[right] - arr[left])) * (x - arr[left]));
            if (arr[p] == x)
                return p;
            if (arr[p] < x)
                left = p + 1;
            else
                right = p - 1;
        }
        return -1;
    }
}
