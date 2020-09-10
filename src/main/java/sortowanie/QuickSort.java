package sortowanie;

import java.util.Arrays;
import java.util.Objects;

public class QuickSort {

    //http://strefakodera.pl/algorytmy/algorytmy-sortowania/przerabiamy-algorytm-quicksort-z-wersji-rekurencyjnej-na-nierekurencyjna
    public static void sort2(int[] tab, int left, int right) {
        if (right <= left)
            return;
        else {
            int q = partition( tab,  left, right)  ;
            sort2(tab,  q+1, right);
            sort2(tab,  left, q-1);
        }
    }

    private static int partition(int[] tab, int left, int right) {
        int pivot = tab[left];

        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (tab[j] <= pivot) {
                i++;
                swap(tab, i, j);
            }
        }
        swap(tab, i, left);
        return i;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    //------------------------------------------------------

    //https://www.vogella.com/tutorials/JavaAlgorithmsQuicksort/article.html
    //https://strefainzyniera.pl/artykul/941/algorytm-quicksort-w-java
    public static void sort(int[] numbers, int start, int end) {
        int pivot = numbers[start];
        int i = start;
        int j = end;
        while (i <= j) {
            while (numbers[i] < pivot) {
                i++;
            }
            while (numbers[j] > pivot) {
                j--;
            }
            if ((i <= j)) {
                swap(numbers, i, j);
                i++;
                j--;
            }
        }
        if (start < j)
            sort(numbers, start, j);
        if (i < end)
            sort(numbers, i, end);
    }
}
