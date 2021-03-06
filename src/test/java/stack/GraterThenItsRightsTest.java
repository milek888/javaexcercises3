package stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraterThenItsRightsTest {

    @Test
    void shouldReturnGreaterElementsStack() {
        int[] numbers = {10,4,6,3,5};
        int[] actualResult = GraterThenItsRights.findGreaterThenTheirRightsStack(numbers);
        int[] expectedResult = {10,6,5};
        assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    void shouldReturnGreaterElementsArray() {
        int[] numbers = {10,4,6,3,5};
        List<Integer> actualResult = GraterThenItsRights.findGreaterThenTheirRightsArray(numbers);
        List<Integer> expectedResult = List.of(10,6,5);
        assertIterableEquals(actualResult, expectedResult);
    }
}