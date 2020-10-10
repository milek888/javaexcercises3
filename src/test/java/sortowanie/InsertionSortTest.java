package sortowanie;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class InsertionSortTest {

    @Test
    void insertionSortTest() {
        int[] numbers = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort.insertionSort(numbers);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expectedResult, numbers);
    }

    @Test
    void insertionSortTest2() {
        int[] numbers = new int[]{8, 4, 67, 52, 4, 13, 2, 1, 2, 2};
        InsertionSort.insertionSort(numbers);
        int[] expectedResult = new int[]{1, 2, 2, 2, 4, 4, 8, 13, 52, 67};
        assertArrayEquals(expectedResult, numbers);
    }

    @Test
    void findPositionRecursiveTest() {
        int[] numbers = new int[]{1, 2, 30, 50, 60};
        int actualPosition = InsertionSort.findPosition(numbers, 0, numbers.length - 1, 4);
        int expectedPosition = 2;
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void findPositionRecursiveTest2() {
        int[] numbers = new int[]{0, 1, 2, 3, 3, 4, 4, 5, 6, 7, 8, 9, 10};
        int actualPosition = InsertionSort.findPosition(numbers, 0, numbers.length - 1, -1);
        int expectedPosition = 0;
        assertEquals(expectedPosition, actualPosition);
    }

    @Test
    void binaryInsertionSortTest() {
        int[] numbers = new int[]{8, 7, 6, 5, 4, 3, 2, 1};
        InsertionSort.binaryInsertionSort(numbers);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        assertArrayEquals(expectedResult, numbers);
    }

    @Test
    void binaryInsertionSortTest2() {
        int[] numbers = new int[]{8, 4, 67, 52, 4, 13, 2, 1, 2, 2};
        InsertionSort.binaryInsertionSort(numbers);
        int[] expectedResult = new int[]{1, 2, 2, 2, 4, 4, 8, 13, 52, 67};
        assertArrayEquals(expectedResult, numbers);
    }

    @Test
    void sortKsortedArrayTest() {
        int[] numbers = new int[]{3, 5, 2, 1, 6, 6, 7, 4, 8, 10, 9};
        InsertionSort.sortKsortedArray(numbers, 4);
        int[] expectedResult = new int[]{1, 2, 3, 4, 5, 6, 6, 7, 8, 9, 10};
        assertArrayEquals(expectedResult, numbers);
    }

    @Test
    void sortKsortedArrayTest2() {
        int[] numbers = new int[]{0, 4, 2, 4, 1, 2, 52, 13, 67, 8, 9};
        InsertionSort.sortKsortedArray(numbers, 6);
        int[] expectedResult = new int[]{0, 1, 2, 2, 4, 4, 8,9, 13, 52, 67};
        assertArrayEquals(expectedResult, numbers);
    }

}