package sortowanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sortowanie.revision.CountingSort;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortTest {

    static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{8,7,5,11,0,5}, new int[]{0,5,5,7,8,11}),
                Arguments.arguments(new int[]{5,3,2,6,4,1,3,7}, new int[]{1,2,3,3,4,5,6,7}));
    }

    static Stream<Arguments> argumentProvider2() {
        return Stream.of(Arguments.arguments(new double[]{0.8,0.7,0.5,0.11,0,0.5}, new double[]{0,0.11,0.5,0.5,0.7,0.8}),
                Arguments.arguments(new double[]{0.5,0.3,0.2,0.6,0.4,0.1,0.3,0.7}, new double[]{0.1,0.2,0.3,0.3,0.4,0.5,0.6,0.7}));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void sort(int[] numbers, int[] expectedResult) {
        BucketSort.sort(numbers);
        assertArrayEquals(expectedResult, numbers);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider2")
    void sort(double[] numbers, double[] expectedResult) {
        BucketSort.sort2(numbers);
        assertArrayEquals(expectedResult, numbers);
    }

}