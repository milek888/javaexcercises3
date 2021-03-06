package sortowanie.revision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {
    static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{8,7,5,11,0,5}, new int[]{0,5,5,7,8,11}),
                Arguments.arguments(new int[]{5,3,2,6,4,1,3,7}, new int[]{1,2,3,3,4,5,6,7}));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void sort(int[] numbers, int[] expectedResult) {
        int[] actualResult =  CountingSort.sort(numbers);
        assertArrayEquals(expectedResult, actualResult);
    }
}