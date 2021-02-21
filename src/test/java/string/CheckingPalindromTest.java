package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckingPalindromTest {

//TODO what about empty or null
// uppercase
   @ParameterizedTest
   @CsvSource({
           "mm, true",
           "madam, true"
   })
    void shouldValidCorrectPalindroms(String input, boolean expectedResult) {
       boolean actualResult = CheckingPalindrom.isPalindrome(input);
       Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldValidCorrectPalindromsForNotOnlyLetters() {
        String input = "*m1a d a1m*";
        boolean expectedResult = true;
        boolean actualResult = CheckingPalindrom.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "ma dam, false",
            "madam1, false"
    })
    void shouldInvalidateInCorrectPalindroms(String input, boolean expectedResult) {
        boolean actualResult = CheckingPalindrom.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldValidPalindromeOfSingleLetter() {
        String input = "w";
        boolean expectedResult = true;
        boolean actualResult = CheckingPalindrom.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}