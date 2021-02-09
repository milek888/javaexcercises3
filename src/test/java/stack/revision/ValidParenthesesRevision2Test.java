package stack.revision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesRevision2Test {

    @ParameterizedTest
    //https://www.codingrevolution.com/junit-5-parameterized-tests/
    //https://mkyong.com/junit5/junit-5-parameterized-tests/
    //Mozna uzyc roznych typow
    @CsvSource({
            "()[]{}, true",
            "(], false",
            "([)], false",
            "{[()]()}, true"
    })
    void isValid(String input, boolean expectedResult) {
        boolean actualResult = ValidParenthesesRevision2.isValid(input);
        assertEquals(expectedResult, actualResult);
    }
}