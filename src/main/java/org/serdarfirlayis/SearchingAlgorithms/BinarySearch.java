package org.serdarfirlayis.SearchingAlgorithms;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int search = 5;
        int index = binarySearch(arr, search);
        System.out.println("Index of " + search + " is " + index);
    }

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (key == array[mid]) {
                return mid;
            } else if (key < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
