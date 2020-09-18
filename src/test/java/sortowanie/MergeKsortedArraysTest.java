package sortowanie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeKsortedArraysTest {//TODO refactor tests

    @Test
    void mergeKSortedArrays() {
        int[][] arr = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        int[] actualResult = MergeKsortedArrays.mergeKSortedArrays(arr, 0, 2);
        int[] expectedResult = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void mergeKSortedArrays2() {
        int[][] arr = { {1, 5, 6, 8},
                {2, 4, 10, 12},
                {3, 7,  11},
                {13, 14, 15, 16}} ;
        int[] actualResult = MergeKsortedArrays.mergeKSortedArrays(arr, 0, 3);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11,12,13,14,15,16};
        assertArrayEquals(expectedResult, actualResult);
    }

    //-----------------------------------------Sposob 2---------------------------------------

    @Test
    void mergeKSortedArraysBottomUp() {
        int[][] arr = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        int[] actualResult = MergeKsortedArrays.mergeKSortedArraysBottomUp(arr);
        int[] expectedResult = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void mergeKSortedArrays2BottomUp2() {
        int[][] arr = { {1, 5, 6, 8},
                {2, 4, 10, 12},
                {3, 7,  11},
                {13, 14, 15, 16}} ;
        int[] actualResult = MergeKsortedArrays.mergeKSortedArraysBottomUp(arr);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11,12,13,14,15,16};
        assertArrayEquals(expectedResult, actualResult);
    }

    //-----------------------------------------Sposob 4---------------------------------------
    @Test
    void mergeKSortedArraysUsingHeap() {
        int[][] arr = {{1, 3, 5, 7},
                {2, 4, 6, 8},
                {0, 9, 10, 11}};
        int[] actualResult = MergeKsortedArrays.mergeKSortedArraysUsingHeap(arr);
        int[] expectedResult = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        assertArrayEquals(expectedResult, actualResult);
    }

    @Test
    void mergeKSortedArraysUsingHeap2() {
        int[][] arr = { {1, 5, 6, 8},
                {2, 4, 10, 12},
                {3, 7,  11},
                {13, 14, 15, 16}} ;
        int[] actualResult = MergeKsortedArrays.mergeKSortedArraysUsingHeap(arr);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 10, 11,12,13,14,15,16};
        assertArrayEquals(expectedResult, actualResult);
    }
}