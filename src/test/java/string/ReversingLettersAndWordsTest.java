package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReversingLettersAndWordsTest {

    @ParameterizedTest
    @CsvSource({
            "Ala ma kota, alA am atok",
            "1 2 30, 1 2 03"
    })
    void reverseWords(String input, String expectedResult) {
        String actualResult = ReversingLettersAndWords.reverseWords(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}