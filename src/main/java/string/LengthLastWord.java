package string;

/*
  https://leetcode.com/problems/length-of-last-word/
* 58. Length of Last Word
  Given a string s consists of some words separated by spaces, return the length of the last word in the string. If the
  last word does not exist, return 0. A word is a maximal substring consisting of non-space characters only
  Input: s = "Hello World"
  Output: 5
* */
public class LengthLastWord {

    public int lengthOfLastWord(String s) {
        int length = 0;
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        while (i >= 0 && Character.isLetter(s.charAt(i))) {
            length++;
            i--;
        }


        return length;
    }
}
