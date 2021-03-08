package slidingwindow.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import slidingwindow.ConsecutiveCharacters;

import static org.junit.jupiter.api.Assertions.*;

class ConsecutiveCharactersRevisionTest {

    @ParameterizedTest
    @CsvSource({
            "aaaa, 4",
            "abbcccddddeeeeedcba, 5",
            "abbcccddddeeeeedcbaxxxxxxxx, 8",
            "abababdd, 2"
    })
    void maxPower(String input, int expectedResult) {
        int actualResult = ConsecutiveCharactersRevision.maxPower(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}