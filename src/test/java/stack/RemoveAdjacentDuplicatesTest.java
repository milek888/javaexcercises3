package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAdjacentDuplicatesTest {

    @ParameterizedTest
    @CsvSource({
            "abbaca, ca",
            "abbcdeefghhgf, acd"
    })
    void removeDuplicates(String input, String expectedResult) {
        String actualResult = RemoveAdjacentDuplicates.removeDuplicates(input);
        assertEquals(expectedResult, actualResult);
    }
}