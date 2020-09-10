package dynamicprogramming.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuySellStockTest {//TODO testy parametryczne

    private BuySellStock buySellStock;

    @BeforeEach
    void setUp() {
        buySellStock = new BuySellStock();
    }

    @Test
    void maxProfitNullPrices() {
        int[] prices = null;
        int actualProfit = buySellStock.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitEmptyPrices() {
        int[] prices = {};
        int actualProfit = buySellStock.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitNoTransaction() {
        int[] prices = {7, 6, 5, 4, 3, 1};
        int actualProfit = buySellStock.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfit() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int actualProfit = buySellStock.maxProfit(prices);
        int expectedProfit = 5;
        assertEquals(expectedProfit, actualProfit);
    }
    @Test
    void maxProfit2() {
        int[] prices = {7, 3, 5, 4, 9, 4, 6, 1, 2, 8};
        int actualProfit = buySellStock.maxProfit(prices);
        int expectedProfit = 7;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfit3() {
        int[] prices = {7, 1, 5, 3, 6, 66};
        int actualProfit = buySellStock.maxProfit(prices);
        int expectedProfit = 65;
        assertEquals(expectedProfit, actualProfit);
    }

//-------------------------------------------------------------------------------

    @Test
    void maxProfitRecursive() {
        int[] prices = {7, 1, 5, 3, 6, 4};
       MinMax minMax = buySellStock.maxProfitRecursive(prices, 5);
        int expectedProfit = 5;
        int actualProfit = minMax.getMax() - minMax.getMin();
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitRecursive2() {
        int[] prices = {7, 3, 5, 4, 9, 4, 6, 1, 2, 8};
        MinMax minMax = buySellStock.maxProfitRecursive(prices, 9);
        int expectedProfit = 7;
        int actualProfit = minMax.getMax() - minMax.getMin();
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitRecursive3() {
        int[] prices = {7, 1, 5, 3, 6, 66};
        MinMax minMax = buySellStock.maxProfitRecursive(prices, 5);
        int expectedProfit = 65;
        int actualProfit = minMax.getMax() - minMax.getMin();
        assertEquals(expectedProfit, actualProfit);
    }
}