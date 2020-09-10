package dynamicprogramming.contigoussubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class LongestAlternatingSubArrayTest {

    @Test
    void findAlternatingSubArray() {
        int[] numbers = {1, -2, 6, 4, -3, 2, -4, -3};

        int[] actualResult = LongestAlternatingSubArray.findAlternatingSubArray(numbers);

        int[] expectedResult = {4, -3, 2, -4};
        assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    void findAlternatingSubArray2() {
        int[] numbers = {1, -2, 6, 4, -3, 2, -4, -3, -3, -1, 1, -1, 1, -1, 1, -1, 1};

        int[] actualResult = LongestAlternatingSubArray.findAlternatingSubArray(numbers);

        int[] expectedResult = {-1, 1, -1, 1, -1, 1, -1, 1};
        assertArrayEquals(actualResult, expectedResult);
    }
}