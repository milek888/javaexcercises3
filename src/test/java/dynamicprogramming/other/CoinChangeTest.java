package dynamicprogramming.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CoinChangeTest {
    private CoinChange coinChange;

    @BeforeEach
    void setUp() {
        coinChange = new CoinChange();
    }

    @ParameterizedTest(name = "{index} --> amount={0} excpectedChanges={1}")
    @CsvSource({
            "6, 2",
            "7, 2",
            "8, 3",
            "13, 4"
    })
    void shouldReturnCorrectNumChangesBottomUp(int amount, int excpectedChanges) {
        int[] coins = {1,2,5};
        int actualChanges = coinChange.coinChangeBottomUp(coins, amount);
        assertEquals(excpectedChanges, actualChanges);
    }


    @ParameterizedTest(name = "{index} --> amount={0} excpectedChanges={1}")
    @CsvSource({
            "2, 1"
    })
    void shouldReturnCorrectNumChangesBottomUp2(int amount, int excpectedChanges) {
        int[] coins = {2,1,3,10};
        int actualChanges = coinChange.coinChangeBottomUp(coins, amount);
        assertEquals(excpectedChanges, actualChanges);
    }

    @ParameterizedTest(name = "{index} --> amount={0} excpectedChanges={1}")
    @CsvSource({
            "19, 3",
            "11, 2"
    })
    void shouldReturnCorrectNumChangesBottomUp3(int amount, int excpectedChanges) {
        int[] coins = {9, 6, 5, 1};
        int actualChanges = coinChange.coinChangeBottomUp(coins, amount);
        assertEquals(excpectedChanges, actualChanges);
    }


    @ParameterizedTest(name = "{index} --> amount={0} excpectedChanges={1}")
    @CsvSource({
            "6, 2",
            "7, 2",
            "8, 3",
            "13, 4"
    })
    void shouldReturnCorrectNumChangesTopDown(int amount, int excpectedChanges) {
        int[] coins = {1,2,5};
        int actualChanges = coinChange.coinChangeTopDownMain(coins, amount);
        assertEquals(excpectedChanges, actualChanges);
    }

}