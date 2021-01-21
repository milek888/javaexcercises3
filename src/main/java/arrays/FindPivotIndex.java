package arrays;

/*
 * LeedCode 724. Find Pivot Index
 * https://leetcode.com/problems/find-pivot-index/
 * */
public class FindPivotIndex {
//nums = [1,7,3,6,5,6]
//       [1,8,11,17,22,28]

    public static int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if (leftsum == sum - leftsum - nums[i]) {
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

}
