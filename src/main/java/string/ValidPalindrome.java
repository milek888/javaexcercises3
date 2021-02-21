package string;

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

    public boolean isPalindrome(String s) {
        int leftIndex = 0;
        int rightIndex = s.length()-1;
        while (leftIndex < rightIndex) {
            while( (!Character.isLetterOrDigit(s.charAt(leftIndex))) && (leftIndex < rightIndex)) {
                leftIndex++;
            }
            while(!Character.isLetterOrDigit(s.charAt(rightIndex)) && (leftIndex < rightIndex)) {
                rightIndex--;
            }
            String leftChar = Character.toString(s.charAt(leftIndex)).toLowerCase();
            String rightChar = Character.toString(s.charAt(rightIndex)).toLowerCase();
            if(!leftChar.equals(rightChar)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
