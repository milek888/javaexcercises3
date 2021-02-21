package string;

import java.util.Stack;

/*
* 917. Reverse Only Letters
*https://leetcode.com/problems/reverse-only-letters/
* */
public class ReverseOnlyLetters {

    public String reverseOnlyLetters(String S) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {//mozna tez zastosowac for (char c: S.toCharArray())
            if (Character.isLetter(S.charAt(i))) {
                characterStack.push(S.charAt(i));
            }
        }
        StringBuilder reversedS = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if (Character.isLetter(S.charAt(i))) {
                reversedS.append(characterStack.pop());
            } else {
                reversedS.append(S.charAt(i));
            }
        }
        return reversedS.toString();
    }
}
