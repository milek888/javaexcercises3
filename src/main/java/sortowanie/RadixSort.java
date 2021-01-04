package sortowanie;

import java.util.Arrays;
/*
Dobrze opisane
   programiz.com/dsa/radix-sort
Najkrotsza wersja
   https://knpcode.com/java-programs/radix-sort-java-program/
   https://www.sanfoundry.com/java-program-implement-radix-sort/
*/

public class RadixSort {

    public static void radixSort(int arr[]) {
        int maxValue = Arrays.stream(arr).max().orElse(0);
        for (int exp = 1; maxValue / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static void countingSort(int[] numbers, int exp) {

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
//https://stackoverflow.com/questions/1484347/finding-the-max-min-value-in-an-array-of-primitives-using-java
//https://www.geeksforgeeks.org/find-max-min-value-array-primitives-using-java/