package stack.revision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import stack.RemoveAdjacentDuplicates;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAdjacentDuplicatesRevisionTest {

    @ParameterizedTest
    @CsvSource({
            "abbaca, ca",
            "abbcdeefghhgf, acd"
    })
    void removeDuplicates(String input, String expectedResult) {
        String actualResult = RemoveAdjacentDuplicatesRevision.removeDuplicates(input);
       assertEquals(expectedResult, actualResult);
    }
}