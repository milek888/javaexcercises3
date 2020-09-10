package other;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstrWithoutRepeatingChars {
    private static final int EXTENDED_ASCII_CODES = 256;
    private Map<Character, Integer> frequencies = new HashMap<>();
    private int[] index = new int[EXTENDED_ASCII_CODES];

    /*
     * using map
     * */
    public int longestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int maxLength = 0;
        int lastIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            Character key = s.charAt(i);
            Integer frequecy = frequencies.get(key);
            if (frequecy != null && frequecy >= lastIndex) {
                lastIndex = frequecy + 1;
            }
            maxLength = Integer.max(maxLength, i + 1 - lastIndex);
            frequencies.put(key, i);
        }
        return maxLength;
    }

    /*
     * using array
     * */
    public int longestSubstringArray(String s) {
        Arrays.fill(index, -1);
        int ans = 0;
        int lastIndex = 0;

        for (int j = 0; j < s.length(); j++) {
            if (index[s.charAt(j)] >= lastIndex) {
                lastIndex = index[s.charAt(j)] + 1;
            }
            ans = Integer.max(ans, j + 1 - lastIndex);
            index[s.charAt(j)] = j;
        }

        return ans;
    }


}
