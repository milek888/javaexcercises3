package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfConsistentStringsTest {
/*
* "ab"
["ad","bd","aaab","baa","badab"]
* */
    @Test
    void countConsistentStrings() {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};

        int actualResult = NumberOfConsistentStrings.countConsistentStrings(allowed, words);
        int expectedResult = 2;
        Assertions.assertEquals(expectedResult, actualResult);
    }
}