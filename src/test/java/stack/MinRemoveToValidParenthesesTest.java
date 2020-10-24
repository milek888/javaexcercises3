package stack;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class MinRemoveToValidParenthesesTest {

    @ParameterizedTest
    @CsvSource({
            "lee(t(c)o)de), lee(t(c)o)de",
            "a)b(c)d, ab(c)d",
            "(a(b(c)d), a(b(c)d)"
    })
    void minRemoveToMakeValid(String input, String expectedResult) {
        String actualResult = MinRemoveToValidParentheses.minRemoveToMakeValid(input);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldRemoveAllParentheses() {
        String actualResult = MinRemoveToValidParentheses.minRemoveToMakeValid("))((");
        String expectedResult = "";
        assertEquals(expectedResult, actualResult);
    }
}