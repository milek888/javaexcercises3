package sortowanie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
 * https://www.geeksforgeeks.org/nearly-sorted-algorithm/
 *https://pl.wikipedia.org/wiki/Sortowanie_przez_wstawianie
 * */
public class SortKsortedArray {

    public static List<Integer> insertionKSortPrioityQueue(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < k + 1; i++) {
            queue.offer(arr[i]);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = k + 1; i < arr.length; i++) {
            result.add(queue.poll());
            queue.offer(arr[i]);
        }
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return result;
    }

    public static void insertionSortWithBinarySearch(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int x = arr[j];
            int insertionPoint = Math.abs(Arrays.binarySearch(arr, 0, j, x) +1 );
            //https://www.geeksforgeeks.org/java-program-for-binary-insertion-sort/
            System.arraycopy(arr, insertionPoint, arr, insertionPoint+1, j-insertionPoint);
            arr[insertionPoint] = x;
        }
    }

    public static void insertionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    private static void swap(int[] arr, int k, int l) {
        int temp = arr[k];
        arr[k] = arr[l];
        arr[l] = temp;
    }
}
