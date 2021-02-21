package string.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class SherlockValidStringTest {

    @ParameterizedTest
    @CsvSource({
            "aaaabbcc, NO",
            "aabbcd, NO",
            "aabbccddeefghi, NO",
            "abcdefghhgfedecba, YES"
    })
    void isValid(String input, String expectedResult) {
       String actualResult = SherlockValidString.isValid(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }


    @ParameterizedTest
    @CsvSource({
            "aaaabbcc, NO"
    })
    void isValid2(String input, String expectedResult) {
        String actualResult = SherlockValidString.isValid(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}