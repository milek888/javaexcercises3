package stack.revision;

import org.junit.jupiter.api.Test;
import stack.GraterThenItsRights;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GraterThenItsRightsRevisionTest {

    @Test
    void shouldReturnGreaterElementsStack() {
        int[] numbers = {10,4,6,3,5};
        int[] actualResult = GraterThenItsRightsRevision.findGreaterThenTheirRightsStack(numbers);
        int[] expectedResult = {10,6,5};
        assertArrayEquals(actualResult, expectedResult);
    }

    @Test
    void shouldReturnGreaterElementsArray() {
        int[] numbers = {10,4,6,3,5};
        List<Integer> actualResult = GraterThenItsRightsRevision.findGreaterThenTheirRightsArray(numbers);
        List<Integer> expectedResult = List.of(10,6,5);
        assertIterableEquals(actualResult, expectedResult);
    }
}