package sortowanie.revision;

import org.junit.jupiter.api.Test;
import sortowanie.InsertionSort;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortRevisionTest {

    @Test
    void mergeSortTest() {
        int[] numbers = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        MergeSortRevision.mergeSort(numbers,0,numbers.length-1);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expectedResult, numbers);
    }

    @Test
    void mergeSortTest2() {
        int[] numbers = new int[]{8, 4, 67, 52, 4, 13, 2, 1, 2, 2};
        MergeSortRevision.mergeSort(numbers,0,numbers.length-1);
        int[] expectedResult = new int[]{1, 2, 2, 2, 4, 4, 8, 13, 52, 67};
        assertArrayEquals(expectedResult, numbers);
    }
}