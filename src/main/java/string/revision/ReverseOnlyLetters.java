package string.revision;

import java.util.Stack;

/*
 * 917. Reverse Only Letters
 *https://leetcode.com/problems/reverse-only-letters/
 * */
public class ReverseOnlyLetters {

    public static String reverseOnlyLetters2(String S) {
        Stack<Character> letters = new Stack();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                letters.push(S.charAt(i));
            }
        }

        StringBuilder ans = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (Character.isLetter(c))
                ans.append(letters.pop());
            else
                ans.append(c);
        }

        return ans.toString();
    }

    public static String reverseOnlyLetters(String S) {
        StringBuilder sb = new StringBuilder(S);
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            while (i < sb.length() - 1 && !Character.isLetter(S.charAt(i))) {
                i++;
            }
            while (j > 0 && !Character.isLetter(S.charAt(j))) {
                j--;
            }
            swapLetters(sb, i, j);
            i++;
            j--;
        }
        return sb.toString();
    }

    private static void swapLetters(StringBuilder sb, int i, int j) {
        char jChar = sb.charAt(j);
        sb.setCharAt(j, sb.charAt(i));
        sb.setCharAt(i, jChar);
    }
}


/*
  Description
* Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
  and all letters reverse their positions.
  Example 1:

    Input: "ab-cd"
    Output: "dc-ba"
    Example 2:

    Input: "a-bC-dEf-ghIj"
    Output: "j-Ih-gfE-dCba"
    Example 3:

    Input: "Test1ng-Leet=code-Q!"
    Output: "Qedo1ct-eeLg=ntse-T!"
*
* */