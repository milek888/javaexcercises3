package string.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import string.LongestPalindromicSubstring;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringRevisionTest {

    @ParameterizedTest
    @CsvSource({
          /*  "mm, mm",*/
            "madam, madam",
            "madam1, madam",
            "2madam1, madam",
            "aaa, aaa"
    })
    void longestPalindrome(String input, String expectedMax) {
        String actualMax = LongestPalindromicSubstringRevision.longestPalindrome(input);
        Assertions.assertEquals(expectedMax, actualMax);
    }

    @Test
    void longestPalindromeWhenSeveralAnswers() {
        String input = "abc";
        Set<String> expectedResult = Set.of("a", "b", "c");
        String actualMax = LongestPalindromicSubstringRevision.longestPalindrome(input);
        Assertions.assertTrue(expectedResult.contains(actualMax));

    }



}