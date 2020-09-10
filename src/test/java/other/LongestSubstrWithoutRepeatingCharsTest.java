package other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstrWithoutRepeatingCharsTest {
    LongestSubstrWithoutRepeatingChars longestSubstrWithoutRepeatingChars;

    @BeforeEach
    void setUp() {
        longestSubstrWithoutRepeatingChars = new LongestSubstrWithoutRepeatingChars();
    }

    @ParameterizedTest
    @CsvSource({
            "abcad1234b5, 9",
            "12345, 5",
            "123451abcde, 10"
    })
    void lengthOfLongestSubstring(String s, int expectedLength) {
        int actualLength = longestSubstrWithoutRepeatingChars.longestSubstring(s);
        assertEquals(expectedLength, actualLength);
    }

    @ParameterizedTest
    @CsvSource({
            "abcad1234b5, 9",
            "12345, 5",
            "123451abcde, 10"
    })
    void lengthOfLongestSubstringArr(String s, int expectedLength) {
        int actualLength = longestSubstrWithoutRepeatingChars.longestSubstringArray(s);
        assertEquals(expectedLength, actualLength);
    }


}