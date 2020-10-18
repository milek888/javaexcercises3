package stack.revision;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class ReversePolishNotationRevisionTest {

    private ReversePolishNotationRevision notationRevision;

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.arguments(new String[]{"4", "13", "5", "/", "+"}, 6));
    }

    @BeforeEach
    void setUp() {
        notationRevision = new ReversePolishNotationRevision();
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void evalRPN(String[] tokens, int expectedResult) {
        int actualResult = notationRevision.evalRPN(tokens);
        assertEquals(expectedResult, actualResult);
    }
}