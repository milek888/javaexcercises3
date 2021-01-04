package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DecodeStringTest {

    @ParameterizedTest
    @CsvSource({
            "3[a]2[bc], aaabcbc",
            "3[a2[c]], accaccacc"
    })
    void decodeString(String input, String expectedResult) {
        DecodeString.decodeString(input);
    }
}