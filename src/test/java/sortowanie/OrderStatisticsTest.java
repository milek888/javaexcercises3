package sortowanie;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatisticsTest {

    static Stream<Arguments> argumentProvider1() {
        return Stream.of(Arguments.arguments(new int[]{8,7,5,11,0,5},5),
                Arguments.arguments(new int[]{5,3,2,6,4,1,3,7}, 3),
                Arguments.arguments(new int[]{1,2,30,4,5,6,7,8,9,10}, 4),
                Arguments.arguments(new int[]{1,2,30,4,5,6,7,8,9,10}, 4));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider1")
    void sort(int[] numbers, int expectedIthSmallest) {
        int actualIthSmallest = OrderStatistics.getIthSmallestElement(numbers, 0, numbers.length-1, 3);
        assertEquals(expectedIthSmallest, actualIthSmallest);
    }

    static Stream<Arguments> argumentProvider2() {
        return Stream.of(Arguments.arguments(new int[]{8,7,5,11,0,5,3,3,3},8),
                Arguments.arguments(new int[]{5,3,2,6,4,1,3,7}, 7),
                Arguments.arguments(new int[]{1,2,30,4,5,6,7,8,90,10}, 10),
                Arguments.arguments(new int[]{1,2,30,4,5,6,7,8,9,10}, 9));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider2")
    void sort2(int[] numbers, int expectedIthSmallest) {
        int actualIthSmallest = OrderStatistics.getIthSmallestElement(numbers, 0, numbers.length-1, 8);
        assertEquals(expectedIthSmallest, actualIthSmallest);
    }
}