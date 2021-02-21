package string.hackerrank;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MakingAnagramsTest {

    @ParameterizedTest
    @CsvSource({
            "cde, abc, 4",
            "fcrxzwscanmligyxyvym, jxwtrhvujlmrpdoqbisbwhmgpmeoke, 30",
            "showman, woman, 2"
    })
    void makeAnagram(String inputA, String inputB, int expectedCount) {
        int actualCount = MakingAnagrams.makeAnagram(inputA, inputB);
        Assertions.assertEquals(actualCount, expectedCount);
    }
}