package sortowanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MergeSortTest {

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{23, 5, 4, 30, 8, 2, 1}, new int[]{1, 2, 4, 5, 8, 23, 30}),
                Arguments.arguments(new int[]{3,2,1}, new int[]{1, 2, 3}));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void sort(int[] elements, int[] expectedOrder) {
        MergeSort.sort(elements, 0, elements.length - 1);
        assertArrayEquals(elements, expectedOrder);
    }
}