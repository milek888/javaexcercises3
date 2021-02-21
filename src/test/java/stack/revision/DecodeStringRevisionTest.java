package stack.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringRevisionTest {

    @ParameterizedTest
    @CsvSource({
            "3[a]2[bc], aaabcbc",
            "3[a2[c]], accaccacc",
            "2[abc]3[cd]ef, abcabccdcdcdef",
            "abc3[cd]xyz, abccdcdcdxyz"
    })
    void decodeString(String input, String expectedResult) {
        String actualResult = DecodeStringRevision.decodeString(input);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}