package stack.revision;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ReversePolishNotationRevision2Test {

    private static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new String[]{"2", "1", "+", "3", "*"}, 9),
                Arguments.arguments(new String[]{"4", "13", "5", "/", "+"}, 6.6));
    }

    private static Stream<Arguments> argumentProvider2() {
        return Stream.of(Arguments.arguments(new String[]{"2.0", "1.0", "+", "3.0", "*"}, 9.0),
                Arguments.arguments(new String[]{"4.0", "15.0", "5.0", "/", "+"}, 7.0));
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void evalRPN(String[] tokens, double expectedResult) {
        double actualResult = ReversePolishNotationRevision2.evalRPN(tokens);
        assertEquals(expectedResult, actualResult);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider2")
    void evalRPN2(String[] tokens, double expectedResult) {
        double actualResult = ReversePolishNotationRevision2.evalRPN(tokens);
        assertEquals(expectedResult, actualResult);
    }
}