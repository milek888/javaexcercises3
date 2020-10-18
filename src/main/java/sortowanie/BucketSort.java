package sortowanie;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * https://eduinf.waw.pl/inf/alg/003_sort/0020.php
 * */
public class BucketSort {

    /*
     * Another way of bucket sort
     * bucketsNum - predefined number of buckets
     * */
    public static void sort2(double[] numbers) {//TODO try to use java 8 streams

        //utworzenie bucketow
        int bucketsNum = calculateBucketsNumber(numbers);
        List<Double>[] buckets = new List[bucketsNum];
        for (int i = 0; i< buckets.length; i++ ) {
            buckets[i] = new LinkedList<>();//linked lista pewnie dlatego ze mniejsze zuzycie pamieci. Bo ArrayList przydziela od razu
            //10 elementow a linked list ma dokladnie tyle ile trzeba.
        }

        //przydzielenie do bucketow
        for (int i = 0; i < numbers.length; i++) {
            int index = (int)(10*numbers[i]);//jak mamy n bucketow to bedzie tu int index = (int)(n*numbers[i])
            buckets[index].add(numbers[i]);
        }

        //sortowanie bucketow
        for (int i = 0; i< buckets.length; i++ ) {
            //Do sortowania Collections.sort oraz Arrays.sort jest stosowany Timsort
            //https://medium.com/@rylanbauermeister/understanding-timsort-191c758a42f3
            Collections.sort(buckets[i]);
        }

        //zmergowanie bucketow
        int j = 0;
        for (int i = 0; i< buckets.length; i++ ) {
            for (double number : buckets[i]) {
                numbers[j] = number;
                j++;
            }
        }
    }

    private static int calculateBucketsNumber(double[] numbers){//TODO
        return 10;
    }

    public static void sort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }

        int n = Arrays.stream(numbers)
                .max()
                .getAsInt();
        int[] frequencies = new int[n + 1];

        for (int number : numbers) {
            frequencies[number]++;
        }

        int j = 0;
        for (int i = 0; i < frequencies.length; i++) {
            while (frequencies[i] > 0) {
                numbers[j] = i;
                j++;
                frequencies[i]--;
            }
        }
    }
}
