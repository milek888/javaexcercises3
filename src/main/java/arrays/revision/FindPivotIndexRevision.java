package arrays.revision;

import java.util.Arrays;

/*
 * LeedCode 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 * */
public class FindPivotIndexRevision {
//nums = [1,7,3,6,5,6]
//       [1,8,11,17,22,28]

    public static int pivotIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if(leftSum == sum - leftSum - nums[i]){
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }



}
