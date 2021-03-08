package slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstrAtMost2DistinctCharsTest {
/*
* * Input: "eceba"
  Output: 3
  Explanation: t is "ece" which its length is 3.

  Input: "ccaabbb"
  Output: 5
  Explanation: t is "aabbb" which its length is 5.
* */
    @ParameterizedTest
    @CsvSource({
            "eceba, 3",
            "ccaabbb, 5"
    })
    void lengthOfLongestSubstringTwoDistinct(String input, int expectedResult) {
        int actualResult = LongestSubstrAtMost2DistinctChars.lengthOfLongestSubstringTwoDistinct(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "eceba, 3",
            "ccaabbb, 5"
    })
    void lengthOfLongestSubstringTwoDistinct2(String input, int expectedResult) {
        int actualResult = LongestSubstrAtMost2DistinctChars.lengthOfLongestSubstringTwoDistinct2(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}