package string.revision;

/*
 * LeetCode 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 * */
public class ReverseStringIIRevision {
    public static String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {
            int start = i;
            int end = Integer.min(i + k - 1, s.length() - 1);
            while (start < end) {
                char temp = chars[end];
                chars[end] = chars[start];
                chars[start] = temp;
                start++;
                end--;
            }

        }
        return String.valueOf(chars);
    }
}
