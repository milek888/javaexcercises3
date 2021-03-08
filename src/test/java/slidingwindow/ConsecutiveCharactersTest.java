package slidingwindow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveCharactersTest {

    @ParameterizedTest
    @CsvSource({
            "aaaa, 4",
            "abbcccddddeeeeedcba, 5",
            "abbcccddddeeeeedcbaxxxxxxxx, 8",
    })
    void maxPower(String input, int expectedResult) {
        int actualResult = ConsecutiveCharacters.maxPower(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}