package arrays.revision;

/*
 * To samo jes w src\main\java\dynamicprogramming\other\BuySellStock.java
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 * */
public class BuySellStock2Revision {

    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int globalMin = Integer.MAX_VALUE;
        int bestEarning = 0;

        for (int i = 0; i < prices.length; i++) {
            globalMin = Integer.min(globalMin, prices[i]);
            if (bestEarning < prices[i] - globalMin) {
                bestEarning = prices[i] - globalMin;
            }
        }
        return bestEarning;
    }

}
