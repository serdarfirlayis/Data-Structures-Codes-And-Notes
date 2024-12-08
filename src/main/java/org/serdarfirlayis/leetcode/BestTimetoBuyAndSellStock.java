package org.serdarfirlayis.leetcode;

/**
 * LeetCode 121 - Best Time to Buy and Sell Stock
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
public class BestTimetoBuyAndSellStock {

    public int maxProfit(int[] prices) {

        int buyPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice) {
                buyPrice = prices[i];
            } else {
                int currentProfit = prices[i] - buyPrice;
                maxProfit = Integer.max(currentProfit, maxProfit);
            }
        }

        return maxProfit;
    }
}
