package arrays;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/
560. Subarray Sum Equals K
* Given an array of integers and an integer k, you need to find the total number of continuous subarrays
*  whose sum equals to k.
* */
public class SubarraySumEqualsTarget {

    public static int subarraySum(int[] nums, int k) {
        int currentSum = 0; //to są kolejne sumy przyrostowe
        int counter = 0;
        HashMap<Integer, Integer> frequencies = new HashMap<>();//to zawiera ile razy dana suma przyrostowa dotychczas wystapila

        for (int number : nums) {
            currentSum += number;

            if (currentSum == k) {
                counter++;
            }
            counter += frequencies.getOrDefault(currentSum - k, 0);
            frequencies.merge(currentSum, 1, Integer::sum);
        }

        return counter;
    }
}
