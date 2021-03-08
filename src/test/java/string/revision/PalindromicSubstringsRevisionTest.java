package string.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PalindromicSubstringsRevisionTest {

    @ParameterizedTest
    @CsvSource({
            "mm, 3",
            "madam, 7",
            "abc, 3",
            "aaa, 6"
    })
    void countSubstrings(String input, int expectedResult) {
        int actualResult = PalindromicSubstringsRevision.countSubstrings(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}