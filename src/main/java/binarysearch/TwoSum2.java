package binarysearch;

/*
 * 167. LeetCode Two Sum II - Input array is sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
 * */
public class TwoSum2 {

    //this has O(n) average
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    //----------------------------------------------------------------------------------------------------------

    //this has O(log(n)) average , O(n) worst case
    public static int[] twoSumBinary(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left;
                result[1] = right;
                return result;
            }
            int mid = (left + right) / 2;
            if (numbers[left] + numbers[right] > target) {
                right = (numbers[left] + numbers[mid] > target) ? mid : right - 1;
            } else {
                left = (numbers[mid] + numbers[right] < target) ? mid : left + 1;
            }
        }
        return result;
    }

    //----------------------------------------------------------------------------------------------------------

    //The best solution, this has O(log(n)) average
    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/discuss/51251/A-O(logN)-binary-search-Java-Solution-0ms-beat-98
    public static int[] twoSumBinaryBetter(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];

        while (start <= end) {
            if (numbers[start] + numbers[end] == target) {
                result[0] = start;
                result[1] = end;
                return result;
            }
            if (numbers[start] + numbers[end] > target) {
                end = largestSmallerOrLastEqual(numbers, start, end, target - numbers[start]);
            } else {
                start = smalestGreaterOrLastEqual(numbers, start, end, target - numbers[end]);
            }
        }
        return result;
    }


    private static int largestSmallerOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    private static int smalestGreaterOrLastEqual(int[] numbers, int start, int end, int target) {
        int left = start;
        int right = end;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (numbers[mid] < target) {
                left = mid + 1;
            } else {
               right = mid -1;
            }
        }
        return left;
    }


}
