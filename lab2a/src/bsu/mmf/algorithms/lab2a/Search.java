package bsu.mmf.algorithms.lab2a;

public class Search {
    int binarySearch(int arr[], int x) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            if (right >= left) {
                int p = left + (right - left) / 2;
                if (arr[p] == x)
                    return p;
                if (arr[p] > x)
                    right = p - 1;
                else left = p + 1;
            }
        }
        return -1;

    }

    int interpolationSearch(int[] arr, int x) {
        int left = 0, right = (arr.length - 1);
        while (left <= right && x >= arr[left] && x <= arr[right]) {
            int p = left + (((right - left)  * (x - arr[left]))/
                    (arr[right] - arr[left]));
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
