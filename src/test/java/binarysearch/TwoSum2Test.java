package binarysearch;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSum2Test {

    static Stream<Arguments> argumentProvider() {
        return Stream.of(
                Arguments.arguments(new int[]{2,7,11,15}, 9, new int[]{0, 1}),
                Arguments.arguments(new int[]{1, 2,   3, 4,   5, 10, 11, 12, 13, 17, 18, 20}, 8, new int[]{2, 4}),
                Arguments.arguments(new int[]{2,7,11,15}, 9, new int[]{0, 1}),
                Arguments.arguments(new int[]{1,2,3,4,5,6,7,8}, 10, new int[]{1, 7}),
                Arguments.arguments(new int[]{1,2,3,7,8}, 10, new int[]{1, 4}));
    }

    //https://mkyong.com/junit5/junit-5-parameterized-tests/
    @ParameterizedTest
    @MethodSource("argumentProvider")
    void twoSum(int[] numbers, int target, int[] expectedSolution) {
        int[] actualSolution = TwoSum2.twoSum(numbers, target);
        assertArrayEquals(expectedSolution, actualSolution);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void twoSumBinary(int[] numbers, int target, int[] expectedSolution) {
        int[] actualSolution = TwoSum2.twoSumBinary(numbers, target);
        assertArrayEquals(expectedSolution, actualSolution);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void twoSumBinaryBetter(int[] numbers, int target, int[] expectedSolution) {
        int[] actualSolution = TwoSum2.twoSumBinaryBetter(numbers, target);
        assertArrayEquals(expectedSolution, actualSolution);
    }

}