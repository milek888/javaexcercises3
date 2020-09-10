package other;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    public static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void shouldReturnCorrectArea(int[] height, int expectedArea) {
        int actualArea = ContainerWithMostWater.maxArea(height);
        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldReturnZeroForEmptyHeihts() {
        int[] height = new int[]{};
        int expectedArea = 0;
        int actualArea = ContainerWithMostWater.maxArea(height);
        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldReturnZeroForNullHeihts() {
        int[] height = null;
        int expectedArea = 0;
        int actualArea = ContainerWithMostWater.maxArea(height);
        assertEquals(expectedArea, actualArea);
    }
}