package string.revision;

/*
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/
 * Given a string s, return the longest palindromic substring in s
 * */
public class LongestPalindromicSubstringRevision {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        String totalMax = "";
        for (int i = 1; i < s.length(); i++) {

            String left = maxPalindromFromCenter(i - 1, i, s);
            String right = maxPalindromFromCenter(i, i, s);
            String localMax = left.length() > right.length() ? left : right;

            if (localMax.length() > totalMax.length()) {
                totalMax = localMax;
            }

        }

        return totalMax;
    }


    private static String maxPalindromFromCenter(int leftCenter, int rightCenter, String s) {
        int left = leftCenter;
        int right = rightCenter;
        String result = "";

        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result = s.substring(left, right+1);
            left--;
            right++;
        }
        return result;
    }//maxPalindromFromCenter

}
