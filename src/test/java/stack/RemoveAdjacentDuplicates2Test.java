package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RemoveAdjacentDuplicates2Test {

    @ParameterizedTest
    @CsvSource({
            "deeedbbcccbdaa, 3, aa",
            "pbbcggttciiippooaais, 2, ps",
            "abcd, 2, abcd"
    })
    void removeDuplicates(String input, int k, String expectedResult) {
        String actualResult = RemoveAdjacentDuplicates2.removeDuplicates(input, k);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "deeedbbcccbdaa, 3, aa",
            "pbbcggttciiippooaais, 2, ps",
            "abcd, 2, abcd"
    })
    void removeDuplicatesOneStack(String input, int k, String expectedResult) {
        String actualResult = RemoveAdjacentDuplicates2.removeDuplicatesOneStack(input, k);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @CsvSource({
            "deeedbbcccbdaa, 3, aa",
            "pbbcggttciiippooaais, 2, ps",
            "abcd, 2, abcd"
    })
    void removeDuplicatesOneStack2(String input, int k, String expectedResult) {
        String actualResult = RemoveAdjacentDuplicates2.removeDuplicatesOneStack2(input, k);
        assertEquals(expectedResult, actualResult);
    }
}