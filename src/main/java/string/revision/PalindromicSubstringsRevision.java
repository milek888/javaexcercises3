package string.revision;

/*
 * Leetcode 647. Palindromic Substrings
 * https://leetcode.com/problems/palindromic-substrings/
 *
 * */
public class PalindromicSubstringsRevision {

    public static int countSubstrings(String s) {
        if (s == null && s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int result = 1;

        for (int i = 1; i < s.length(); i++) {
            result += countFromCenter(i - 1, i, s);
            result += countFromCenter(i, i, s);
        }

        return result;
    }

    private static int countFromCenter(int leftCenter, int rightCenter, String s) {
        int counter = 0;
        int left = leftCenter;
        int right = rightCenter;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {

            counter++;
            left--;
            right++;
        }
        return counter;
    }//countFromCenter

}
