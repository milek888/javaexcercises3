package sortowanie;

public class CountingSort {

    public static int[] sort(int[] numbers) {

        int[] frequencies = new int[10];
        for(int number: numbers) {
            frequencies[number]++;
        }

        for(int i=1; i< frequencies.length; i++) {
            frequencies[i] = frequencies[i] + frequencies[i-1];
        }

        int[] sortedNumbers = new int[numbers.length];
        for(int i = numbers.length-1; i>=0; i--) {
            sortedNumbers[frequencies[numbers[i]]-1] = numbers[i];
            frequencies[numbers[i]]--;
        }

        return sortedNumbers;
    }

}
