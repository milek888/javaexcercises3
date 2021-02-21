package string;

/*
* 5. Longest Palindromic Substring
* https://leetcode.com/problems/longest-palindromic-substring/
* Given a string s, return the longest palindromic substring in s
* */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        int count = 0;
        String max = "";
        for (int i = 0; i < s.length(); i++) {
            String max1 = centreMax(s, i, i, max);
            max = max1.length() > max.length() ? max1 : max;
            String max2 = centreMax(s, i, i + 1,max);
            max = max2.length() > max.length() ? max2 : max;
        }
        return max;
    }

    private static String centreMax(String s, int left, int right, String max) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) != s.charAt(right)) {
                break;
            }
            if(max.length() < s.substring(left, right+1).length()) {
                max = s.substring(left, right+1);
            }
            count++;
            left--;
            right++;
        }
        return max;
    }
}
/*
* Examples
*
 Example 1:
    Input: s = "babad"
    Output: "bab"
    Note: "aba" is also a valid answer.

  Example 2:
    Input: s = "cbbd"
    Output: "bb"

  Example 3:
    Input: s = "a"
    Output: "a"
* */
