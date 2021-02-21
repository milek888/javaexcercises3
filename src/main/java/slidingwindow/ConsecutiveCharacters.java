package slidingwindow;

/*
*https://leetcode.com/problems/consecutive-characters/
* 1446. Consecutive Characters
* Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
* Input: s = "abbcccddddeeeeedcba"
  Output: 5
  Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
* */
public class ConsecutiveCharacters {
    public static int maxPower(String s) {
        if (s.length() == 1) {
            return 1;
        }
        int maxLength = 1;
        int currentLength = 1;


        for (int i= 1; i < s.length(); i++) {

            if (s.charAt(i) == s.charAt(i - 1)) {
                currentLength++;
                maxLength = Math.max(maxLength, currentLength);
            } else {
                currentLength = 1;
            }

        }

        return maxLength;
    }
}
