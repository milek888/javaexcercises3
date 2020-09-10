package dynamicprogramming.other;

import java.util.stream.IntStream;
/*
* f(k) = max(f(k – 2) + Ak, f(k – 1))
* */
public class HouseRobber {

    public static int rob(int[] nums) {
        int prev = 0;
        int result = 0;
        for (int num : nums) {
            int temp = result;
            result = Integer.max(prev + num, result);
            prev = temp;
        }
        return result;
    }

}
