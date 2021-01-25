package arrays.revision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BuySellStock2RevisionTest {

    private static Stream<Arguments> argumentProvider(){
        return Stream.of(Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5), Arguments.of(new int[]{7, 3, 5, 4, 9, 4, 6, 1, 2, 8}, 7),
                Arguments.of(new int[]{7, 1, 5, 3, 6, 66}, 65),Arguments.of(new int[]{7,6,4,3,1}, 0));
    }

    @Test
    void maxProfitNullPrices() {
        int[] prices = null;
        int actualProfit = BuySellStock2Revision.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitEmptyPrices() {
        int[] prices = {};
        int actualProfit = BuySellStock2Revision.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }

    @Test
    void maxProfitNoTransaction() {
        int[] prices = {7, 6, 5, 4, 3, 1};
        int actualProfit = BuySellStock2Revision.maxProfit(prices);
        int expectedProfit = 0;
        assertEquals(expectedProfit, actualProfit);
    }


    @ParameterizedTest
    @MethodSource("argumentProvider")
    void maxProfit2(int[] prices, int expectedProfit) {
        int actualProfit = BuySellStock2Revision.maxProfit(prices);
        assertEquals(expectedProfit, actualProfit);
    }

}