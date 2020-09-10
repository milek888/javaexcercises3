package dynamicprogramming.other;

import java.util.HashMap;
import java.util.Map;

/*
 * https://www.techiedelight.com/find-n-digit-binary-strings-without-consecutive-1s/
 * */
public class Conssecutive1s {
    Map<Integer, Integer> values0 = new HashMap<>();
    Map<Integer, Integer> values1 = new HashMap<>();

    /*
     * Time complexity is exponential
     * */
    public int countStrings(int n, int lastDigit) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return (lastDigit == 0) ? 2 : 1;
        }
        if (lastDigit == 0) {
            return countStrings(n - 1, 0) + countStrings(n - 1, 1);
        } else {
            return countStrings(n - 1, 0);
        }
    }

    /*
     * Dynamic programming bottom-up approach. Doesn't take into account lastDigit
     * */
    public int countStringsDpUp(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 2;
        }
        int prev0 = 1;
        int prev1 = 1;
        int next0 = 0;
        int next1 = 0;
        for (int i = 2; i <= n; i++) {
            next0 = prev0 + prev1;
            next1 = prev0;
            prev0 = next0;
            prev1 = next1;
        }
        return next0 + next1;
    }

    /*
     * Dynamic programming top-down approach
     * */
    public int countStringsDpDown(int n, int lastDigit) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return (lastDigit == 0) ? 2 : 1;
        }

        int result0 = getPartialResult(n, values0, 0);
        if (lastDigit == 0) {
            int result1 = getPartialResult(n, values1, 1);
            return result0 + result1;
        } else {
            return result0;
        }
    }

    private int getPartialResult(int n, Map<Integer, Integer> values, int i) {
        int result = 0;
        if (values.get(n - 1) != null) {
            result = values.get(n - 1);
        } else {
            result = countStrings(n - 1, i);
        }
        return result;
    }

}
