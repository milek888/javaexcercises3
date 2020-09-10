package dynamicprogramming.contigoussubarray;

import java.util.Arrays;

/*
 * Longest Alternating Subarray is a problem of finding a subarray with alternating positive and negative elements,
 *  and in which the subarray is as long as possible.
 *  For example, consider array { 1, -2, 6, 4, -3, 2, -4, -3 } the longest subarray is {4, -3, 2, -4}
 * https://www.techiedelight.com/longest-alternating-subarray-problem/
 * */
public class LongestAlternatingSubArray {//TODO test edge results null, empty, < 2 arrays

    public static int[] findAlternatingSubArray(int[] numbers) {
        if (numbers != null) {
            throw new NullInputDataException();
        }
        if (numbers.length < 2) {
            return numbers;
        }

        int maxLength = 0;
        int maxStart = 0;
        int maxTempStart = 0;
        int tempLength = 0;
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] * numbers[i] < 0) {
                tempLength++;
                if(tempLength > maxLength) {
                    maxStart = maxTempStart;
                    maxLength = tempLength;
                }
            } else {
                maxTempStart = i;
                tempLength = 1;
            }
        }
        return Arrays.copyOfRange(numbers, maxStart, maxStart+maxLength);
    }


}
