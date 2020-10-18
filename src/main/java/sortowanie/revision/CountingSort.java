package sortowanie.revision;

import java.util.Arrays;

//https://eduinf.waw.pl/inf/alg/003_sort/0023.php
public class CountingSort {

    public static int[] sort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new int[0];//Bloch Effective java temat 43 zwracanie tablic dlugosci 0 zamiast null
        }

        int n = Arrays.stream(numbers)
                .max()
                .getAsInt();
        int[] frequencies = new int[n+1];

        for (int number : numbers) {
            frequencies[number]++;
        }

        for (int i = 1; i < frequencies.length; i++) {
            frequencies[i] += frequencies[i - 1];
        }

        int[] output = new int[numbers.length];//deklaracje zmiennych powinny byc jak najblizej ich wykorzystania
        for (int i = numbers.length - 1; i >= 0; i--) {
            output[frequencies[numbers[i]] - 1] = numbers[i];
            frequencies[numbers[i]]--;
        }
        return output;

    }
}
