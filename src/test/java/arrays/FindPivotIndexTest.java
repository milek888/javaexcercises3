package arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindPivotIndexTest {

    @Test
    void pivotIndexTest() {
        int[] numbers = new int[]{1,7,3,6,5,6};
        int actualResult = FindPivotIndex.pivotIndex(numbers);
        int expectedResult = 3;
    }

    @Test
    void pivotIndexNotExists() {
        int[] numbers = new int[]{1,2,3};
        int actualResult = FindPivotIndex.pivotIndex(numbers);
        int expectedResult = -1;
    }

    @Test
    void pivotIndex2() {
        int[] numbers = new int[]{-1,-1,-1,0,1,1};
        int actualResult = FindPivotIndex.pivotIndex(numbers);
        int expectedResult = -1;
    }

}