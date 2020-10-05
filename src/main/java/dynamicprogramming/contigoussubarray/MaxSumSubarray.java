package dynamicprogramming.contigoussubarray;

/*
* We have an array with integers. Find max sum of the contigues subarray.
* https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
* */

public class MaxSumSubarray {

    /*
     * This works only when at least number is positive
     * */
    public static int calculateSumForPositives(int[] nums) {

        int maxSum = 0;
        int maxSoFar = 0;

        for (int number : nums) {
            maxSoFar += number;
            maxSoFar = Integer.max(0, maxSoFar);
            maxSum = Integer.max(maxSoFar, maxSum);
        }

        return maxSum;
    }

    /*
     * This works also when all are negatives
     * */
    public static int calculateSumForIntegers(int[] nums) {

        int maxSum = nums[0];
        int maxSoFar = nums[0];

        for(int i = 1; i < nums.length; ++i) {
            maxSoFar += nums[i];
            maxSoFar = Integer.max(nums[i], maxSoFar);
            maxSum = Integer.max(maxSoFar, maxSum);
        }

        return maxSum;
    }

    /*
    https://leetcode.com/problems/maximum-subarray/solution/
     * This works also when all are negatives with dynamic programming and slightly shorter theb above
     * */
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for(int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
