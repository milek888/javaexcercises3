package sortowanie;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;

//https://www.geeksforgeeks.org/merge-sort/
public class MergeSort {

    public static void sort(int[] elements, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        sort(elements, start, mid);
        sort(elements, mid + 1, end);
        merge(elements, start, mid, end);

    }
    private static void merge(int[] elements, int start, int mid, int end) {
        int[] left = Arrays.copyOfRange(elements, start, mid + 1);
        int[] right = Arrays.copyOfRange(elements, mid + 1, end + 1);

        int i = 0;
        int j = 0;
        int k = start;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                elements[k] = left[i];
                i++;
            } else {
                elements[k] = right[j];
                j++;
            }
            k++;
        }

        if (i < left.length) {
            System.arraycopy(left, i, elements, k, left.length - i);
        }
        if (j < right.length) {
            System.arraycopy(right, j, elements, k, right.length - j);
        }
    }


}
