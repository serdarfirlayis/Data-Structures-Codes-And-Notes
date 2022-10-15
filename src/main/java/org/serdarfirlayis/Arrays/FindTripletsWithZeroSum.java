package org.serdarfirlayis.Arrays;

import java.util.ArrayList;
import java.util.HashSet;

public class FindTripletsWithZeroSum {

    public static void main(String[] args) {
        int[] arr = {0, -1, 2, -3, 1};
        boolean triplets = findTriplets(arr, arr.length);
        System.out.println(triplets);
    }

    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum

    // Time Complexity: O(n^2)
    // Space Complexity: O(n)
    static boolean findTriplets(int[] arr, int n) {

        for (int i = 0; i < n - 1; i++) {
            HashSet<Integer> hashSet = new HashSet<Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = -(arr[i] + arr[j]);
                if (hashSet.contains(x)) {
                    return true;
                } else {
                    hashSet.add(arr[j]);
                }
            }
        }
        return false;
    }

    // Time Complexity: O(n^3)
    // Space Complexity: O(1)
    public static boolean findTriplets2(int arr[], int n) {
        // Arraylist for storing all the triplets
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        ans.add(temp);
                    }
                }
            }
        }
        if (ans.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
