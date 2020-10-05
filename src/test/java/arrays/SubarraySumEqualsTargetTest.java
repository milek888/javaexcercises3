package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SubarraySumEqualsTargetTest {

    @Test
    void subarraySum() {
        int actualResult = SubarraySumEqualsTarget.subarraySum(new int[]{3, 4, 1, 2, 2, -12, 1, 2, 2, 5}, 7);
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void subarraySum2() {
        int actualResult = SubarraySumEqualsTarget.subarraySum(new int[]{1,1,1}, 2);
        int expectedResult = 2;
        assertEquals(expectedResult, actualResult);
    }
}