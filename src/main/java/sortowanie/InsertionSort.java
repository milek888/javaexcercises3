package sortowanie;


import java.util.Arrays;
import java.util.PriorityQueue;

/*
 *  Powtorka
 * Different algos: insertionSort, binaryInsertionSort, findPosition
 * */
public class InsertionSort {//TODO refactor tests

    public static void insertionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (numbers[j] < numbers[j - 1]) {
                    swap(numbers, j - 1, j);
                }
            }
        }
    }

    public static void binaryInsertionSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int j = i + 1;
            int x = numbers[j];
            int insIdx = Math.abs(Arrays.binarySearch(numbers, 0, j, x) + 1);
            System.arraycopy(numbers, insIdx, numbers, insIdx + 1, j - insIdx);
            numbers[insIdx] = x;
        }
    }

    //assumption numbers is K-sorted array and numbers.length < K + 1
    public static void sortKsortedArray(int[] numbers, int K) {
        if (numbers.length < K + 1) {
            return;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < K + 1; i++) {
            queue.add(numbers[i]);
        }

        int j = 0;
        int i = K + 1;
        while (!queue.isEmpty()) {
            int min = queue.poll();
            if (i < numbers.length) {
                queue.add(numbers[i]);
                i++;
            }
            numbers[j] = min;
            j++;
        }
    }

    //Finds where a given value should be placed in sorted array
    //Assumption value <= max(numbers[i])
    //this is different then java algo Arrays.binarySearch
    public static int findPosition(int[] numbers, int left, int right, int value) {
        int mid = (left + right) / 2;
        if (left == right) {
            return left;
        }
        if (value > numbers[mid]) {
            return findPosition(numbers, mid + 1, right, value);
        } else {
            return findPosition(numbers, left, mid, value);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
