package sortowanie;

//Na podstawie Corman Wprowacenie do algorytmow
public class OrderStatistics {

    public static int getIthSmallestElement(int[] elements, int p, int r, int i) {
        if (p == r) {
            return elements[p];
        }
        int q = partition(elements, p, r);
        if (i == q+1) {
            return elements[q];
        }
        if (i < q+1) {
            return getIthSmallestElement(elements, p, q - 1, i);
        } else {
            return getIthSmallestElement(elements, q + 1, r, i);
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
}
