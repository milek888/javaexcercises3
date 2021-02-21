package string;


/*
 *  LeetCode 14. Longest Common Prefix
 *  https://leetcode.com/problems/longest-common-prefix/
 * */
public class LongestCommonPrefix {

    public static String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder("");
        if (strs == null || strs.length == 0) {
            return result.toString();
        }

        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return result.toString();
                }
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }
}
/*
* Write a function to find the longest common prefix string amongst an array of strings.
  If there is no common prefix, return an empty string "".
  Example 1:

  Input: strs = ["flower","flow","flight"]
  Output: "fl"
*
* */
