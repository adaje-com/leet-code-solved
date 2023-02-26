package leetcode._121besttimetobuyandsellstock;

class Solution {
    public int maxProfit(int[] prices) {
        int minimumPriceSoFar = prices[0];
        int maximumProfit = 0;
        for (int day = 1; day < prices.length; day++) {
            minimumPriceSoFar = Math.min(prices[day], minimumPriceSoFar);
            maximumProfit = Math.max(prices[day] - minimumPriceSoFar, maximumProfit);
        }
        return maximumProfit;
    }
}
