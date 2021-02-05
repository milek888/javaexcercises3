package arrays.revision;

/*
 * 167. LeetCode Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * */
public class TwoSum2Revision {

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start, end};
            }
            if (numbers[start] + numbers[end] > target) {
                end--;
            } else {
                start++;
            }
        }
        return new int[2];
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start, end};
            }
            int mid = (start + end) / 2;
            if (numbers[start] + numbers[end] > target) {
                end = (numbers[start] + numbers[mid] > target ? mid : end -1);
            } else {
                start = (numbers[start] + numbers[mid] < target ? mid : start +1);
            }
        }
        return new int[2];
    }

}
