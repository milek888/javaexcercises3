package slidingwindow.revision;

import java.util.HashMap;

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
public class LongestSubstrAtMost2DistinctCharsRevision {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> charFrequency = new HashMap<>();
        int counter = 1;
        int max = 1;
        int left = 0;
        charFrequency.merge(s.charAt(0), 1, Integer::sum);

        for (int right = 1; right < s.length(); right++) {
            charFrequency.merge(s.charAt(right), 1, Integer::sum);

            if (charFrequency.size() > 2) {
                int updatedFreq = charFrequency.merge(s.charAt(left), -1, Integer::sum);
                if (updatedFreq == 0) {
                    charFrequency.remove(s.charAt(left));
                }
                left++;
                counter = right - left + 1;
            } else {
                counter++;
                max = Math.max(max, counter);
            }

        }
        return max;
    }
}
