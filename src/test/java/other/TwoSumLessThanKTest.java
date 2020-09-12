package other;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoSumLessThanKTest {

    static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[]{499,780,837,984,481,526,944,482,862,136,265,605,5,631,974,967,574,293,969,467,573,845,102,224,17,873,648,120,694,996,244,313,404,129,899,583,541,314,525,496,443,857,297,78,575,2,430,137,387,319}, 1000,999),
                Arguments.arguments(new int[]{34, 23, 1, 24, 75, 33, 54, 8}, 60, 58),
                Arguments.arguments(new int[]{34, 23, 1, 20, 75, 33, 54, 8}, 60, 57));
    }

    @DisplayName("Should return biggest sum greater then K")
    @ParameterizedTest
    @MethodSource("argumentProvider")
    void shouldReturnBiggestSumLessThanK(int[] numbers, int K, int expectedSum) {
        int actualSum = TwoSumLessThanK.twoSumLessThanK(numbers, K);
        assertEquals(expectedSum, actualSum);
    }

    @DisplayName("Should return -1 when no result")
    @Test
    void testWhenNoResult() {
        int[] numbers = new int[]{10,20,30};
        int actualSum = TwoSumLessThanK.twoSumLessThanK(numbers, 8);
        int expectedSum = -1;
        assertEquals(expectedSum, actualSum);
    }

}