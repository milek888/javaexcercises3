package sortowanie.revision;

import java.util.Arrays;

public class MergeSortRevision {

    public static void mergeSort(int[] numbers, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;
        mergeSort(numbers, left, mid);
        mergeSort(numbers, mid + 1, right);

        mergeTables(numbers, left, mid, right);
    }

    private static void mergeTables(int[] numbers, int left, int mid, int right) {
        int[] leftArr = Arrays.copyOfRange(numbers, left, mid+1);
        int[] rightArr = Arrays.copyOfRange(numbers, mid + 1, right+1);

        int i = 0;
        int j = 0;
        int k = left;
        while (i < leftArr.length && j < rightArr.length) {
            if (leftArr[i] <= rightArr[j]) {
                numbers[k] = leftArr[i];
                i++;
            } else {
                numbers[k] = rightArr[j];
                j++;
            }
            k++;
        }

        if (i < leftArr.length) {
            System.arraycopy(leftArr, i, numbers, k, leftArr.length - i);
        }
        if (j < rightArr.length){
            System.arraycopy(rightArr, j, numbers, k, rightArr.length - j);
        }
    }
}
