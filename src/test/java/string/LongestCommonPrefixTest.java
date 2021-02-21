package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LongestCommonPrefixTest {

    @Test
    void longestCommonPrefix() {
        String[] words =  {"flower","flow","flight"};
        String expectedResult = "fl";
        String actualResult = LongestCommonPrefix.longestCommonPrefix(words);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void longestCommonPrefix2() {
        String[] words =  {"dog","racecar","car"};
        String expectedResult = "";
        String actualResult = LongestCommonPrefix.longestCommonPrefix(words);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}