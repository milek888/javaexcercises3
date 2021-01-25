package arrays.revision;

import arrays.SubarraySumEqualsTarget;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubarraySumEqualsTargetRevisionTest {

    @Test
    void subarraySum() {
        int actualResult = SubarraySumEqualsTargetRevision.subarraySum(new int[]{3, 4, 1, 2, 2, -12, 1, 2, 2, 5}, 7);
        int expectedResult = 4;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void subarraySum2() {
        int actualResult = SubarraySumEqualsTargetRevision.subarraySum(new int[]{1,1,1}, 2);
        int expectedResult = 2;
        assertEquals(expectedResult, actualResult);
    }
}