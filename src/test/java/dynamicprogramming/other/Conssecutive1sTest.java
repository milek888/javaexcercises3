package dynamicprogramming.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Conssecutive1sTest {

    private Conssecutive1s conssecutive1s;

    @BeforeEach
    void setUp() {
        this.conssecutive1s = new Conssecutive1s();
    }

    @Test
    void countStrings() {
        int actualResult = conssecutive1s.countStrings(5, 0);
        int expectedResult = 13;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void countStringsDpUpLast0() {
        int actualResult = conssecutive1s.countStringsDpUp(5);
        int expectedResult = 13;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void countStringsDpDownLast0() {
        int actualResult = conssecutive1s.countStringsDpDown(6, 0);
        int expectedResult = 21;
        assertEquals(actualResult, expectedResult);
    }

    @Test
    void countStringsDpDownLast1() {
        int actualResult = conssecutive1s.countStringsDpDown(6, 1);
        int expectedResult = 13;
        assertEquals(actualResult, expectedResult);
    }
}