package string;

/*
 * LeetCode 541. Reverse String II
 * https://leetcode.com/problems/reverse-string-ii/
 * */
public class ReverseStringII {

    public static String reverseStr(String s, int k) {

        char[] a = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k) {

            int end = Integer.min(i + k - 1, a.length - 1);
            int start = i;

            while (start < end) {
                char temp = a[end];
                a[end--] = a[start];
                a[start++] = temp;
            }

        }

        return String.valueOf(a);
    }

}
/*
* Opis
* Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from the
* start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but greater
* than or equal to k characters, then reverse the first k characters and left the other as original.
  Example:
  Input: s = "abcdefg", k = 2
  Output: "bacdfeg"
*
* */
