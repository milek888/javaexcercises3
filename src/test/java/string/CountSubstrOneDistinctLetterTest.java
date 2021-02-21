package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CountSubstrOneDistinctLetterTest {

    @ParameterizedTest
    @CsvSource({
            "aaaba, 8",
            "aaaaaaaaaa, 55"
    })
    void countLetters(String input, int expectedResult) {
        int actualResult = CountSubstrOneDistinctLetter.countLetters(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }


}