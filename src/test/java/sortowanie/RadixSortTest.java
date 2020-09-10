package sortowanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {

    static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{800,700,500,1100,0,500}, new int[]{0,500,500,700,800,1100}),
                Arguments.arguments(new int[]{5,3,2,6,4,1,3,7}, new int[]{1,2,3,3,4,5,6,7}),
                Arguments.arguments(new int[]{170, 45, 75, 90, 802, 24, 2, 66}, new int[]{2,24,45,66,75,90,170,802}));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void sort(int[] numbers, int[] expectedSolution) {
        RadixSort.radixSort(numbers);
        assertArrayEquals(expectedSolution, numbers);
    }
}