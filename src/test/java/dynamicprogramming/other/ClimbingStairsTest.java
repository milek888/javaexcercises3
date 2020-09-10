package dynamicprogramming.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {

    ClimbingStairs climbingStairs;

    @BeforeEach
    void setUp() {
        climbingStairs = new ClimbingStairs();
    }

    @DisplayName("Should calculate number of steps for recursive method")
    @ParameterizedTest(name = "{index} => n={0} expectedSteps={1}")
    @CsvSource({
            "3, 3",
            "4, 5",
            "5, 8",
            "6, 13",
            "7, 21",
    })
    void climbStairsRecursive(int n, int expectedSteps) {
        int actualSteps = climbingStairs.climbStairsRecursive(n);
        assertEquals(expectedSteps, actualSteps);
    }

    @DisplayName("Should calculate number of steps for bottom-up dynamic programming method")
    @ParameterizedTest(name = "{index} => n={0} expectedSteps={1}")
    @CsvSource({
            "3, 3",
            "4, 5",
            "5, 8",
            "6, 13",
            "7, 21",
    })
    void climbStairs(int n, int expectedSteps) {
        int actualSteps = climbingStairs.climbStairs(n);
        assertEquals(expectedSteps, actualSteps);
    }

    @DisplayName("Should calculate number of steps for bottom-up dynamic programming method")
    @ParameterizedTest(name = "{index} => n={0} expectedSteps={1}")
    @CsvSource({
            "3, 3",
            "4, 5",
            "5, 8",
            "6, 13",
            "7, 21",
    })
    void climbStairsTopDown(int n, int expectedSteps) {
        int actualSteps = climbingStairs.climbStairsTopDown(n);
        assertEquals(expectedSteps, actualSteps);
    }
}