package string.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidPalindromeTest {

    @Test
    void isPalindrome() {
        String input = "A man, a plan, a canal: Panama";
        boolean expectedResult = true;
        boolean actualResult = ValidPalindrome.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPalindrome2() {
        String input = "A man, a plan, a cKnal: Panama";
        boolean expectedResult = false;
        boolean actualResult = ValidPalindrome.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPalindrome3() {
        String input = "A man, a plan, a cnal: Panama";
        boolean expectedResult = false;
        boolean actualResult = ValidPalindrome.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPalindromeEmptyString() {
        String input = "";
        boolean expectedResult = true;
        boolean actualResult = ValidPalindrome.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void isPalindromeStringWithNoAlfaNumeric() {
        String input = ", ,!";
        boolean expectedResult = false;
        boolean actualResult = ValidPalindrome.isPalindrome(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}