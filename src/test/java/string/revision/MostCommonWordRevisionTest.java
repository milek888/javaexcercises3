package string.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MostCommonWordRevisionTest {

    @Test
    void mostCommonWord() {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        String expectedResult = "ball";
        String actualResult = MostCommonWordRevision.mostCommonWord(paragraph, banned);
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    void mostCommonWord2() {
        String paragraph = "a.";
        String[] banned = {};
        String expectedResult = "a";
        String actualResult = MostCommonWordRevision.mostCommonWord(paragraph, banned);
        Assertions.assertEquals(expectedResult, actualResult);
    }

}