package string.revision;

/*
  https://leetcode.com/problems/valid-palindrome/
* 125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
Note: For the purpose of this problem, we define empty string as valid palindrome.
Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true
* */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        int i =0;
        int j = s.length()-1;
        while (i < j) {
            while (i < s.length()-1 && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j > 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }
}
