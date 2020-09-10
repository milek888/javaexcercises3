package dynamicprogramming.other;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HouseRobberTest {

    @Test
    void shouldReturn0ForNullInput() {
        int[] nums = null;
        int actualMoney = HouseRobber.rob(nums);
        int expectedMoney = 0;
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    void rob() {
        int[] nums = {};
        int actualMoney = HouseRobber.rob(nums);
        int expectedMoney = 0;
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    void rob2() {
        int[] nums = {2, 7, 9, 3, 1};
        int actualMoney = HouseRobber.rob(nums);
        int expectedMoney = 12;
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    void rob3() {
        int[] nums = {2, 1, 1, 2};
        int actualMoney = HouseRobber.rob(nums);
        int expectedMoney = 4;
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    void rob4() {
        int[] nums = {1, 3, 1, 3, 100};
        int actualMoney = HouseRobber.rob(nums);
        int expectedMoney = 4;
        assertEquals(expectedMoney, actualMoney);
    }

}