package other;

import java.util.Arrays;
import java.util.Collections;

/*
* LeetCode 1099. Two Sum Less Than K
* https://leetcode.com/problems/two-sum-less-than-k/
*
* */
public class TwoSumLessThanK {
    public static int twoSumLessThanK(int[] A, int K) {
        Arrays.sort(A);
       /* radixSort(A);*/
       /* A = Arrays.stream(A)
                .sorted()
                .toArray();*/
        //jakie algorytmy java 8 uzywa wewnwtrznie do sortowania tablicy, kolekcji, straemu
        //https://stackoverflow.com/questions/32334319/why-does-collections-sort-use-mergesort-but-arrays-sort-does-not
        //https://stackoverflow.com/questions/49798129/what-is-more-efficient-sorted-stream-or-sorting-a-list

        int i = 0;
        int j = A.length - 1;
        int maxSumLessThenK = -1;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            if (A[i] + A[j] >= K) {
                j = A[i] + A[mid] >= K && mid < j ? mid : j-1;
            }
            if (A[i] + A[j] < K) {
                maxSumLessThenK = Integer.max(maxSumLessThenK, A[i] + A[j]);
                i = A[mid] + A[j] < K && mid > i ? mid : i+1;
            }
        }

        return maxSumLessThenK;
    }

    private static void radixSort(int arr[]) {
        int maxValue = Arrays.stream(arr).max().orElse(0);
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private static void countingSort(int[] numbers, int exp) {

        int[] frequencies = new int[10];
        for (int number : numbers) {
            frequencies[(number / exp) % 10]++;
        }

        for (int i = 1; i < frequencies.length; i++) {
            frequencies[i] = frequencies[i] + frequencies[i - 1];
        }

        int[] sortedNumbers = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            sortedNumbers[frequencies[(numbers[i] / exp) % 10] - 1] = numbers[i];
            frequencies[(numbers[i] / exp) % 10]--;
        }

        for (int i = 0; i < numbers.length; i++)
            numbers[i] = sortedNumbers[i];
    }

}
