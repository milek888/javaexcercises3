package string;

/*
*  LeetCode 1180. Count Substrings with Only One Distinct Letter
*  https://leetcode.com/problems/count-substrings-with-only-one-distinct-letter/
* */
public class CountSubstrOneDistinctLetter {

    public static int countLetters(String S) {
        if (S == null || S.length() == 0) {
            return 0;
        }
        if (S.length() == 1) {
            return 1;
        }
        int totalCount = 0;
        int start = 0;
        for (int end = 1; end <= S.length(); end++) {
            if (end == S.length() || S.charAt(end) != S.charAt(end - 1)) {
                totalCount += countSubstringsFor1LetterString(end - start);
                start = end;//resetujemy bo zaczyna sie nowy ciaglu substring
            }
        }
        return totalCount;
    }

    private static int countSubstringsFor1LetterString(int length) {
        return (length + 1) * length / 2;
    }
}
/*
* Description
* Given a string S, return the number of substrings that have only one distinct letter.
 Example 1:
 Input: S = "aaaba"
 Output: 8
    Explanation: The substrings with one distinct letter are "aaa", "aa", "a", "b".
    "aaa" occurs 1 time.
    "aa" occurs 2 times.
    "a" occurs 4 times.
    "b" occurs 1 time.
    So the answer is 1 + 2 + 4 + 1 = 8.
*
* */
