import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringValidatorTest {

    StringValidator stringValidator;

    @BeforeEach
    void setUp() {
        stringValidator = new StringValidator();
    }

    @Test
    void validateString1() {
        boolean expectedResult = false;
        boolean actualResult = stringValidator.validateString("cabcmaagmggcaccbcc");
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void validateString2() {
        boolean expectedResult = true;
        boolean actualResult = stringValidator.validateString("aabbcc");
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void validateString3() {
        boolean expectedResult = true;
        boolean actualResult = stringValidator.validateString("aabbccd");
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void validateString4() {
        boolean expectedResult = false;
        boolean actualResult = stringValidator.validateString("aabbccde");
        assertTrue(expectedResult == actualResult);
    }

    @Test
    void validateString5() {
        boolean expectedResult = false;
        boolean actualResult = stringValidator.validateString("aabbccddeefghi");
        assertTrue(expectedResult == actualResult);
    }


    @Test
    void validateString6() {
        boolean expectedResult = true;
        boolean actualResult = stringValidator.validateString("abcdefghhgfedecba");
        assertTrue(expectedResult == actualResult);
    }
}