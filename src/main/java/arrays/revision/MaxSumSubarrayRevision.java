package arrays.revision;

/*
 * We have an array with integers. Find max sum of the contigues subarray.
 * https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
 * */
public class MaxSumSubarrayRevision {

    public static int calculateSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return Integer.MAX_VALUE; // or exception or 0 depends of business requirements
        }
        int tempMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            tempMax += nums[i];
            tempMax = Integer.max(nums[i], tempMax);
            globalMax = Integer.max(globalMax, tempMax);
        }
        return globalMax;
    }
}
