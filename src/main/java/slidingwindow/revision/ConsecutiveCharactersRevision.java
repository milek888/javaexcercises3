package slidingwindow.revision;

/*
*https://leetcode.com/problems/consecutive-characters/
* 1446. Consecutive Characters
* Given a string s, the power of the string is the maximum length of a non-empty substring that contains only one unique character.
* Input: s = "abbcccddddeeeeedcba"
  Output: 5
  Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
* */
public class ConsecutiveCharactersRevision {

    public static int maxPower(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }

        int counter = 1;
        int max = 1;
        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i) != s.charAt(i-1)){
                max = Math.max(max, counter);
                counter = 1;
            } else {
                counter++;
            }
        }
        return max;
    }

}
