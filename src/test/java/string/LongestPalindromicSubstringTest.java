package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @ParameterizedTest
    @CsvSource({
            "mm, mm",
            "madam, madam",
            "madam1, madam",
            "2madam1, madam",
            "abc, a",
            "aaa, aaa"
    })
    void longestPalindrome(String input, String expectedMax) {
        String actualMax = LongestPalindromicSubstring.longestPalindrome(input);
        Assertions.assertEquals(expectedMax, actualMax);
    }
}