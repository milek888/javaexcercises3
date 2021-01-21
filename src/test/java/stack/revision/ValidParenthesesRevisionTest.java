package stack.revision;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesRevisionTest {

    private ValidParenthesesRevision validParenthesesRevision;

    @BeforeEach
    void setUp() {
        validParenthesesRevision = new ValidParenthesesRevision();
    }

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
        boolean actualResult = validParenthesesRevision.isValid(input);
        assertEquals(expectedResult, actualResult);
    }


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
    void isValid2(String input, boolean expectedResult) {
        boolean actualResult = validParenthesesRevision.isValid2(input);
        assertEquals(expectedResult, actualResult);
    }
}