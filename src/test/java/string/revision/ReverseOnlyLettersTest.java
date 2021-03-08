package string.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReverseOnlyLettersTest {

    @ParameterizedTest
    @CsvSource({
            "ab-cd, dc-ba",
            "a-bC-dEf-ghIj, j-Ih-gfE-dCba",
            "Test1ng-Leet=code-Q!, Qedo1ct-eeLg=ntse-T!"
    })
    void reverseOnlyLetters(String input, String expectedResult) {
        String actualResult = ReverseOnlyLetters.reverseOnlyLetters(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "ab-cd, dc-ba",
            "a-bC-dEf-ghIj, j-Ih-gfE-dCba",
            "Test1ng-Leet=code-Q!, Qedo1ct-eeLg=ntse-T!"
    })
    void reverseOnlyLetters2(String input, String expectedResult) {
        String actualResult = ReverseOnlyLetters.reverseOnlyLetters2(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}