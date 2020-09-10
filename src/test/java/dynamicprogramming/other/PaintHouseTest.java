package dynamicprogramming.other;

import dynamicprogramming.other.painthouse.PaintHouse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class PaintHouseTest {

    PaintHouse paintHouse;

    @BeforeEach
    void setUp() {
        paintHouse = new PaintHouse();
    }

    @Test
    void shoulBe0ForNullCosts() {
        int[][] costs = null;
        int actualCost = paintHouse.minCost(costs);
        int expectedCost = 0;
        assertEquals(actualCost, expectedCost);
    }

    @Test
    void shoulBe0ForEmptyCosts() {
        int[][] costs = {{}};
        int actualCost = paintHouse.minCost(costs);
        int expectedCost = 0;
        assertEquals(actualCost, expectedCost);
    }

    //TODO What to do for such cases: int[][] costs = {{},{}} OR {{1,2,3}, {} } OR {{},{1,2,3} } OR {{1,2,3}, {},{1,2,3} }
    //OR negative numbers {{-1,2,3} ,{1,2,3} } OR Brakujace wartosci {{1,3} ,{1,2,3} }
    //TODO sporobowac dopisac w metodzie
    @ParameterizedTest
    @MethodSource("argumentProvider")
    void minCost(int[][] costs, int expectedCost) {
        int actualCost = paintHouse.minCost(costs);
        assertEquals(actualCost, expectedCost);
    }

    //---------------------------------iterative solution------------------------------------

    //What to do for such cases: int[][] costs = {{},{}} OR {{1,2,3}, {} } OR {{},{1,2,3} } OR {{1,2,3}, {},{1,2,3} }

    @Test
    void shoulBe0ForNullCosts2() {
        int[][] costs = null;
        int actualCost = paintHouse.minCost(costs);
        int expectedCost = 0;
        assertEquals(actualCost, expectedCost);
    }

    @Test
    void shoulBe0ForEmptyCosts2() {
        int[][] costs = {{}};
        int actualCost = paintHouse.minCost(costs);
        int expectedCost = 0;
        assertEquals(actualCost, expectedCost);
    }

    @ParameterizedTest
    @MethodSource("argumentProvider")
    void minCostIter3(int[][] costs, int expectedCost) {
        int actualCost = paintHouse.minCostIterative(costs);
        assertEquals(actualCost, expectedCost);
    }

    static Stream<Arguments> argumentProvider() {
        return Stream.of(Arguments.arguments(new int[][]{{17, 2, 17}, {8, 4, 10}, {6, 3, 19}, {4, 8, 12}}, 17),
                Arguments.arguments(new int[][]{{17, 2, 17}, {8, 4, 10}}, 10),
                Arguments.arguments(new int[][]{{17, 2, 17}}, 2));
    }
}