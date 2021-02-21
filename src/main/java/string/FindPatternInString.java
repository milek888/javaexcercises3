package string;


/*
 *  LeetCode 28. Implement strStr()
 *  https://leetcode.com/problems/implement-strstr/
 * */
public class FindPatternInString {

    //---------------------------------------------------Rabin Karp---------------------------------------------------

    public static int strStrRabinKarp(String haystack, String needle) {

        int needleLength = needle.length();
        int n = haystack.length();
        int needleHash = calculateInitialHash(needle);
        int haystackHash = 0;

        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }


        for (int i = 0; i < n - needleLength + 1; i++) {

            if (i == 0) {
                haystackHash = calculateInitialHash(haystack.subSequence(0, needleLength).toString());
            } else {
                haystackHash = calculateRollingHash(haystack.substring(i - 1, i + needleLength), haystackHash);
            }

            boolean isEqual = (needleHash == haystackHash) && comparePattern(haystack.substring(i, i + needleLength), needle);
            if (isEqual) {
                return i;
            }

        }//for

        return -1;
    }

    private static boolean comparePattern(String haystackSubstring, String needle) {
        return haystackSubstring.equals(needle);
    }

    private static int calculateRollingHash(String input, int currentHash) {
        int needleLength = input.length() - 1;
        int substract = (int) ((input.charAt(0) - 'a') * Math.pow(26, needleLength-1));
        int add = input.charAt(needleLength) - 'a';
        return (currentHash - substract) * 26 + add;
    }

    private static int calculateInitialHash(String input) {
        int hash = 0;
        for (int i = 0; i < input.length(); i++) {
            hash = hash * 26;
            hash += input.charAt(i) - 'a';
        }
        return hash;
    }

    //---------------------------------------------------drugi sposob---------------------------------------------------

    public static int strStr(String haystack, String needle) {
        int start = 0;
        int end = 0;
        int currLength = 0;

        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int l = needle.length();
        int n = haystack.length();
        while (end < n - l + 1) {
            while (end < n - l + 1 && haystack.charAt(end) != needle.charAt(0)) {
                end++;
            }
            while (end < n && currLength < l && haystack.charAt(end) == needle.charAt(start)) {
                end++;
                start++;
                currLength++;
            }
            if (currLength == l) {
                return end - currLength;
            } else {
                end = end - currLength + 1;
                start = 0;
                currLength = 0;
            }
        }

        return -1;
    }

}
/*
* Description
* Implement strStr().
    Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
    Clarification:
    What should we return when needle is an empty string? This is a great question to ask during an interview.
    For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

    Example 1:
    Input: haystack = "hello", needle = "ll"
    Output: 2
    Example 2:

    Input: haystack = "aaaaa", needle = "bba"
    Output: -1
    Example 3:

    Input: haystack = "", needle = ""
    Output: 0
* */
