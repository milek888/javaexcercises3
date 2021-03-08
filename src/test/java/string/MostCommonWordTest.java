package string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import string.revision.MostCommonWordRevision;

public class MostCommonWordTest {
    @Test
    void mostCommonWord() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String expectedResult = "ball";
        String actualResult = MostCommonWord.mostCommonWord(paragraph, banned);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void mostCommonWord2() {
        String paragraph = "a.";
        String[] banned = {};
        String expectedResult = "a";
        String actualResult = MostCommonWord.mostCommonWord(paragraph, banned);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
