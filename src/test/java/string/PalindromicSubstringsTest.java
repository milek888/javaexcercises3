package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringsTest {

    @ParameterizedTest
  @CsvSource({
          "mm, 3",
          "madam, 7",
          "abc, 3",
          "aaa, 6"
  })
    void countSubstrings(String input, int expectedResult) {
        int actualResult = PalindromicSubstrings.countSubstrings(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "mm, 3",
            "madam, 7",
            "abc, 3",
            "aaa, 6"
    })
    void countSubstringsBrutForce(String input, int expectedResult) {
        int actualResult = PalindromicSubstrings.countSubstringsBrutForce(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "mm, 3",
            "madam, 7",
            "abc, 3",
            "aaa, 6"
    })
    void countSubstringsDynamicProg(String input, int expectedResult) {
        int actualResult = PalindromicSubstrings.countSubstringsDynamicProg(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}