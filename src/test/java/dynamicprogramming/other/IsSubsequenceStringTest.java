package dynamicprogramming.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IsSubsequenceStringTest {
    IsSubsequenceString isSubsequenceString;

    @BeforeEach
    void setUp() {
        isSubsequenceString = new IsSubsequenceString();
    }

    @ParameterizedTest(name = "{index} --> source {0} target {1} expected {2}")
    @CsvSource({
            "abcyx, ahbgdcxyz, false",
            "abc, ahbgdc, true",
            "axc, ahbgdc, false",
            "amnxy, bc1a333bggm44nmiloszxAgatay, true"
    })
    void isSubsequenceMySolution(String source, String target, boolean expectedResult) {
        boolean actualResult = isSubsequenceString.isSubsequence(source, target);
        assertEquals(actualResult, expectedResult);
    }

    //----------------------------------------------------------------------------

    @ParameterizedTest(name = "{index} --> source {0} target {1} expected {2}")
    @CsvSource({
            "abcyx, ahbgdcxyz, false",
            "abc, ahbgdc, true",
            "axc, ahbgdc, false",
            "amnxy, bc1a333bggm44nmiloszxAgatay, true"
    })
    void isSubsequenceLeetCode(String source, String target, boolean expectedResult) {
        boolean actualResult = isSubsequenceString.isSubsequence2(source, target);
        assertEquals(actualResult, expectedResult);
    }

}