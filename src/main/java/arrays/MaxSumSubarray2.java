package arrays;


import java.util.Arrays;

/*
* It's the same as src\main\java\dynamicprogramming\contigoussubarray\MaxSumSubarray.java
*ttps://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
* */
public class MaxSumSubarray2 {

    public static int calculateSumForIntegers(int[] nums) {
        if(nums == null || nums.length == 0) {
           return Integer.MIN_VALUE;
        }
        int currentMax = nums[0];
        int globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            currentMax += nums[i];
            currentMax = Integer.max(nums[i], currentMax);
            globalMax = Integer.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
