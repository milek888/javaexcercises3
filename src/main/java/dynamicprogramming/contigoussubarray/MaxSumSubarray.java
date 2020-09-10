package dynamicprogramming.contigoussubarray;

/*
* We have an array with integers. Find max sum of the contigues subarray.
* https://www.techiedelight.com/maximum-subarray-problem-kadanes-algorithm/
* */

public class MaxSumSubarray {

    /*
     * This works only when at least number is positive
     * */
    public static int calculateSumForPositives(int[] inputNumbers) {

        int maxSum = 0;
        int maxSoFar = 0;

        for (int number : inputNumbers) {
            maxSoFar += number;
            maxSoFar = Integer.max(0, maxSoFar);
            maxSum = Integer.max(maxSoFar, maxSum);
        }

        return maxSum;
    }

    /*
     * This works only when at least number is positive
     * */
    public static int calculateSumForIntegers(int[] inputNumbers) {

        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int number : inputNumbers) {
            maxEndingHere = maxEndingHere + number;
            maxEndingHere = Integer.max(maxEndingHere, number);
            maxSoFar = Integer.max(maxEndingHere, maxSoFar);
        }

        return maxSoFar;
    }
}
