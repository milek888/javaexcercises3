package stack.revision;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NextGreaterElementRevisionTest {

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2}, new int[]{-1, 3, -1}),
                Arguments.arguments(new int[]{2, 4}, new int[]{1, 2, 3, 4}, new int[]{3, -1}),
                Arguments.arguments(new int[]{2, 5}, new int[]{2, 3, 5, 1, 0, 7, 3}, new int[]{3, 7}),
                Arguments.arguments(new int[]{0, 5, 3, 2, 1, 4}, new int[]{0, 5, 3, 2, 1, 4}, new int[]{5, -1, 4, 4, 4, -1}));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void nextGreaterElement(int[] nums1, int[] nums2, int[] expectedResult) {
        int[] actualResult = NextGreaterElementRevision.nextGreaterElement(nums1, nums2);
        assertArrayEquals(expectedResult, actualResult);
    }
}