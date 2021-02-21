package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {
/*
* Input: s = "anagram", t = "nagaram"
Output: true
* */
    @ParameterizedTest
    @CsvSource({
            "anagram, nagaram",
            "nagarrram, rnagaramr",
            "123anagram, n2aga1ram3"
    })
    void shouldBeCorrectAnagrams(String s, String t) {
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "anagramw, nagaram",
            "nagarrram, rnaga",
            "1ram, n2aga1ram3"
    })
    void shouldNotBeCorrectAnagrams(String s, String t) {
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldNotBeAnagramForFirsEmptyAndSecondNotEmptyString() {
        String s = "";
        String t = "121";
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldNotBeAnagramForSecondEmptyAndFirstNotEmptyString() {
        String t = "";
        String s = "121";
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldBeAnagramForBothEmptyStrings() {
        String t = "";
        String s = "";
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = true;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldNotBeAnagramForFirstInputsNull() {
        String t = null;
        String s = "";
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldNotBeAnagramForSecondInputsNull() {
        String t = "";
        String s = null;
        boolean actualResult = ValidAnagram.isAnagram(s, t);
        boolean expectedResult = false;
        Assertions.assertEquals(expectedResult, actualResult);
    }

}