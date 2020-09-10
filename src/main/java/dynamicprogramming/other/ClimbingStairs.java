package dynamicprogramming.other;

import java.util.HashMap;
import java.util.Map;

/*
 * LeetCode70. Climbing Stairs
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * https://leetcode.com/problems/climbing-stairs/
 * */
public class ClimbingStairs {
    private Map<Integer, Integer> stepsCounts = new HashMap<>();

    /*
     * Bottom up dynamic programming algorithm
     * */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int prev = 1;
        int result = 2;
        for (int i = 3; i <= n; i++) {
            int temp = result;
            result = result + prev;
            prev = temp;
        }
        return result;
    }

    /*
     * Recursive method
     * */
    public int climbStairsRecursive(int n) {
        if (n <= 2) {
            return n;
        }
        int result = climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
        return result;
    }

    public int climbStairsTopDown(int n) {
        if (n <= 2) {
            return n;
        }

        if(!stepsCounts.containsKey(n)) {
            int val = climbStairsTopDown(n - 2) + climbStairsTopDown(n - 1);
            stepsCounts.put(n,val);
        }

        return stepsCounts.get(n);
    }

}
