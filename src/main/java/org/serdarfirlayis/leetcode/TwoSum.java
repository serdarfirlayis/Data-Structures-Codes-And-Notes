package org.serdarfirlayis.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };

        TwoSum twoSum = new TwoSum();
        int[] result = twoSum.twoSum(nums, 9);

        System.out.println(result[0] + " " + result[1]);
    }

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (map.containsKey(diff)) {
                return new int[] { map.get(diff), i };
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[0];
    }
}
