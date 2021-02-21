package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class FindPatternInStringTest {

    @ParameterizedTest
    @CsvSource({
            "hello, ll, 2",
            "miloszmazurek, maz, 6",
            "ala, a, 0",
            "a, a, 0"
    })
    void strStr(String haystack, String needle, int expectedResult) {
        int actualResult = FindPatternInString.strStr(haystack, needle);
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @CsvSource({
            "hello, ll, 2",
            "miloszmazurek, maz, 6",
            "ala, a, 0",
            "a, a, 0",
            "szedlgrzesprzezwies, wies, 15",
            "aaaaa, bba, -1",
            "'','',0"
    })
    void strStrRabinKarp(String haystack, String needle, int expectedResult) {
        int actualResult = FindPatternInString.strStrRabinKarp(haystack, needle);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}