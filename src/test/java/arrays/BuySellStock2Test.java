package arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuySellStock2Test {

    private BuySellStock2 buySellStock2;

    @BeforeEach
    void setUp() {
        buySellStock2 = new BuySellStock2();
    }

    @Test
    void maxProfitNullPrices() {
        int[] prices = null;
        int actualProfit = buySellStock2.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitEmptyPrices() {
        int[] prices = {};
        int actualProfit = buySellStock2.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitNoTransaction() {
        int[] prices = {7, 6, 5, 4, 3, 1};
        int actualProfit = buySellStock2.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfit() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int actualProfit = buySellStock2.maxProfit(prices);
        int expectedProfit = 5;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfit2() {
        int[] prices = {7, 3, 5, 4, 9, 4, 6, 1, 2, 8};
        int actualProfit = buySellStock2.maxProfit(prices);
        int expectedProfit = 7;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfit3() {
        int[] prices = {7, 1, 5, 3, 6, 66};
        int actualProfit = buySellStock2.maxProfit(prices);
        int expectedProfit = 65;
        assertEquals(expectedProfit, actualProfit);
    }
}