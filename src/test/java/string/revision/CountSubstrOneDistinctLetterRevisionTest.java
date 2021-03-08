package string.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import string.CountSubstrOneDistinctLetter;

import static org.junit.jupiter.api.Assertions.*;

class CountSubstrOneDistinctLetterRevisionTest {

    @ParameterizedTest
    @CsvSource({
            "aaaba, 8",
            "aaaaaaaaaa, 55",
            "aaa, 6"
    })
    void countLetters(String input, int expectedResult) {
        int actualResult = CountSubstrOneDistinctLetterRevision.countAllSubstrings(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}