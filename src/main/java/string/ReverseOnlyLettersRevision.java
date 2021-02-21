package string;

import java.util.Stack;

/*
 * 917. Reverse Only Letters
 * https://leetcode.com/problems/reverse-only-letters/
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place,
 * and all letters reverse their positions
 *
 *
 * */
public class ReverseOnlyLettersRevision {

    public String reverseOnlyLetters(String S) {
        Stack<Character> lettersStack = new Stack<>();
        StringBuilder invertedString = new StringBuilder();

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                lettersStack.push(S.charAt(i));
            }
        }

        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                invertedString.append(lettersStack.pop());
            } else {
                invertedString.append(S.charAt(i));
            }
        }
        return invertedString.toString();
    }
}

/*
* Examples
* Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
* */