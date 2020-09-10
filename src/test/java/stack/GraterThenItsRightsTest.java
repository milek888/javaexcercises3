package stack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraterThenItsRightsTest {

    @Test
    void shouldReturnGreaterElementsStack() {
        int[] numbers = {10,4,6,3,5};
        int[] actualResult = GraterThenItsRights.findGreaterThenTheirRightsStack(numbers);
        int[] expectedResult = {5,6,10};
        assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    void shouldReturnGreaterElementsArray() {
        int[] numbers = {10,4,6,3,5};
        List<Integer> actualResult = GraterThenItsRights.findGreaterThenTheirRightsArray(numbers);
        List<Integer> expectedResult = List.of(5,6,10);
        assertIterableEquals(actualResult, expectedResult);
    }
}