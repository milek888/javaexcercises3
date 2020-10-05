package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSumSubarray2Test {
    @Test
    void shouldCalculateWithAllPositive() {
        int[] inputNumbers = {1,2,3,4,5,6,7,8,9,10};
        int actualSum = MaxSumSubarray2.calculateSumForIntegers(inputNumbers);
        int expectedSum = 55;

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void shouldCalculateWithOneNegative() {
        int[] inputNumbers = {1,2,3,4,5,6,-22,8,9,10};
        int actualSum = MaxSumSubarray2.calculateSumForIntegers(inputNumbers);
        int expectedSum = 27;

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void shouldCalculateWithManyNegative() {
        int[] inputNumbers = {1,2,3,4,5,6,-22,8,9,-1,10};
        int actualSum = MaxSumSubarray2.calculateSumForIntegers(inputNumbers);
        int expectedSum = 26;

        assertEquals(expectedSum, actualSum);
    }

    //------------------------------------------------------------------------------------------------------------------

    @Test
    void shouldCalculXXX() {
        int[] inputNumbers = {8,-3,-5,-1, 0,9};
        int actualSum = MaxSumSubarray2.calculateSumForIntegers(inputNumbers);
        int expectedSum = 9;

        assertEquals(expectedSum, actualSum);
    }


    @Test
    void shouldCalculateWithOneNegative2() {
        int[] inputNumbers = {1,2,3,4,5,6,-22,8,9,10};
        int actualSum = MaxSumSubarray2.calculateSumForIntegers(inputNumbers);
        int expectedSum = 27;

        assertEquals(expectedSum, actualSum);
    }

    @Test
    void shouldCalculateWithManyNegative2() {
        int[] inputNumbers = {-10, -8, -9, -4,-3, -10};
        int actualSum = MaxSumSubarray2.calculateSumForIntegers(inputNumbers);
        int expectedSum = -3;

        assertEquals(expectedSum, actualSum);
    }

}