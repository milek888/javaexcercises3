package slidingwindow;


import java.util.HashMap;
import java.util.Map;

/*
* https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
* 159. Longest Substring with At Most Two Distinct Characters
* Given a string s , find the length of the longest substring t  that contains at most 2 distinct characters.
* Input: "eceba"
  Output: 3
  Explanation: t is "ece" which its length is 3.

  Input: "ccaabbb"
  Output: 5
  Explanation: t is "aabbb" which its length is 5.
  *
* */
public class LongestSubstrAtMost2DistinctChars {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> frequencies = new HashMap<>();
        frequencies.put(s.charAt(0), 1);
        int maxLength = 1;
        int currentLength = 1;
        int leftIndex = 0;

        for (int i = 1; i < s.length(); i++) {

            frequencies.merge(s.charAt(i), 1, Integer::sum);

            if (frequencies.size() > 2) {

                int updatedFrequency = frequencies.merge(s.charAt(leftIndex), -1, Integer::sum);
                if (updatedFrequency == 0) {
                    frequencies.remove(s.charAt(leftIndex));
                }
                leftIndex++;
                currentLength = i - leftIndex + 1;

            } else {
                currentLength++;
                maxLength = Integer.max(maxLength, currentLength);
            }
        }
        return maxLength;
    }
}
