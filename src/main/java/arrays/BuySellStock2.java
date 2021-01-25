package arrays;

/*
 * To samo jes w src\main\java\dynamicprogramming\other\BuySellStock.java
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 * */
public class BuySellStock2 {

    public static int maxProfit(int[] prices) {
        if (prices == null) {
            return 0;
        }
        int maxTransaction = 0;//In this case, no transaction is done, i.e. max profit = 0.
        int currentMin = Integer.MAX_VALUE;

        for (int i =0; i<prices.length;i++) {
            currentMin = Integer.min(currentMin, prices[i]);
            maxTransaction = Integer.max(maxTransaction, prices[i] - currentMin);
        }
        return maxTransaction;
    }
}
