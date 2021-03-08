package string.revision;

/*
 *  LeetCode 1180. Count Substrings with Only One Distinct Letter
 *  https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
 * */
public class CountSubstrOneDistinctLetterRevision {

    public static int countAllSubstrings(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        int totalSum = 0;
        int strLength = 1;
        for (int i = 1; i <= S.length();i++) {
            if (i < S.length() && S.charAt(i) == S.charAt(i - 1) ) {
                strLength ++;
            } else {
                totalSum += countSubstrings(strLength);
                strLength = 1;
            }
        }
        return totalSum;
    }

    private static int countSubstrings(int strLength) {
        return (strLength + 1)*strLength/2;
    }
}
