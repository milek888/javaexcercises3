package sortowanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SortKsortedArrayTest {

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{3,2,1}, new int[]{1, 2, 3}),
                Arguments.arguments(new int[]{23, 5, 4, 30, 8, 2, 1}, new int[]{1, 2, 4, 5, 8, 23, 30}));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void insertionSort(int[] elements, int[] expectedOrder) {
        SortKsortedArray.insertionSort(elements);
        assertArrayEquals(expectedOrder, elements);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void insertionSortWithBinarySearch(int[] elements, int[] expectedOrder) {
        SortKsortedArray.insertionSortWithBinarySearch(elements);
        assertArrayEquals(expectedOrder, elements);
    }

    private static Stream<Arguments> argumentProviderForKSort() {
        return Stream.of(Arguments.arguments(new int[]{3,2,1}, new int[]{1, 2, 3}),
                Arguments.arguments(new int[]{3,2,1,4,7,6,5,8,9,110,10}, new int[]{1,2,3,4,5,6,7,8,9,10,110}));
    }

    @ParameterizedTest
    @MethodSource("argumentProviderForKSort")
    void insertionKSortPrioityQueue(int[] elements, int[] expectedOrder) {
        List<Integer> actualResult = SortKsortedArray.insertionKSortPrioityQueue(elements, 2);
        List<Integer> expectedOrderList = Arrays.stream(expectedOrder).boxed().collect(Collectors.toList());
        assertEquals(expectedOrderList, actualResult);
    }

}