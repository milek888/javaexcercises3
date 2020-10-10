package sortowanie.revision;

public class QuickSortRevision {


    public static void sort2(int[] numbers, int left, int right) {
        if (right <= left) {
            return;
        }
        int q = partition3(numbers, left, right);
        sort(numbers, left, q);
        sort(numbers, q + 1, right);
    }
    /*
     * The second way of partitioning with 2 pointers
     * To partycjonowanie zwraca intex podzialu ale nie jest to index pivota (i nie musi byc)
     * */
    private static int partition2(int[] numbers, int left, int right) {
        int pivot = numbers[left];
        int i = left;
        int j = right;
        while (i < j) {
            if (numbers[i] <= pivot) {
                i++;
            }
            if (numbers[j] > pivot) {
                j--;
            }
            if (numbers[i] > pivot && numbers[j] <= pivot) {
                swap(numbers, j, i);
                i++;
                j--;
            }
        }
        return Math.min(i, j);//wazne zeby zwracac mniejsza z tych wartosci
    }

    public static void sort3(int[] numbers, int left, int right) {
        if (right <= left) {
            return;
        }
        int q = partition3(numbers, left, right);
        sort(numbers, left, q);
        sort(numbers, q + 1, right);
    }
/*
* To partycjonowanie zwraca intex podzialu ale nie jest to index pivota (i nie musi byc)
* */
    public static int partition3(int[] numbers, int start, int end) {
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
        return Math.min(i, j);//wazne zeby zwracac mniejsza z tych wartosci
    }
//---------------------------------------------------------------------------------

    public static void sort(int[] numbers, int left, int right) {
        if (right <= left) {
            return;
        }
        int q = partition(numbers, left, right);
        sort(numbers, q + 1, right);
        sort(numbers, left, q - 1);
    }

    /*
    * To partycjonowanie zwraca intex pivota
    * */
    private static int partition(int[] numbers, int left, int right) {
        int pivot = numbers[left];
        int i = left;
        for (int j = left + 1; j <= right; j++) {
            if (numbers[j] < pivot) {
                i++;
                swap(numbers, j, i);
            }
        }
        swap(numbers, i, left);
        return i;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
