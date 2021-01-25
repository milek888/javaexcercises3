package arrays.revision;


import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
560. Subarray Sum Equals K
* Given an array of integers and an integer k, you need to find the total number of continuous subarrays
*  whose sum equals to k.
* */
public class SubarraySumEqualsTargetRevision {

    public static int subarraySum(int[] nums, int k) {
        int counter = 0;
        int currentSum = 0;
        Map<Integer, Integer> prefixSums = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];

            if (currentSum == k) {
                counter++;
            }
            counter += prefixSums.getOrDefault(currentSum - k, 0);

            prefixSums.merge(currentSum, 1, Integer::sum);
        }
        return counter;
    }
}
