package string;

import java.util.Map;

/*
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/
 * */
public class RomanToInteger {

    private static final Map<Character, Integer> romanToIntegerMap = Map.of('I', 1, 'V', 5, 'X', 10,
            'L', 50, 'C', 100, 'D', 500, 'M', 1000);

    public static int romanToInt(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = romanToIntegerMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int prevNumber = romanToIntegerMap.get(s.charAt(i + 1));
            int currNumber = romanToIntegerMap.get(s.charAt(i));
            if (currNumber >= prevNumber){
                result += currNumber;
            } else {
                result -= currNumber;
            }
        }

        return result;
    }

}
