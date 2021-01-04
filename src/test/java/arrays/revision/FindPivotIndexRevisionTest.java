package arrays.revision;

import arrays.FindPivotIndex;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexRevisionTest {

    @Test
    void pivotIndexTest() {
        int[] numbers = new int[]{1,7,3,6,5,6};
        int actualResult = FindPivotIndexRevision.pivotIndex(numbers);
        int expectedResult = 3;
    }

    @Test
    void pivotIndexNotExists() {
        int[] numbers = new int[]{1,2,3};
        int actualResult = FindPivotIndexRevision.pivotIndex(numbers);
        int expectedResult = -1;
    }

    @Test
    void pivotIndex2() {
        int[] numbers = new int[]{-1,-1,-1,0,1,1};
        int actualResult = FindPivotIndexRevision.pivotIndex(numbers);
        int expectedResult = -1;
    }
}