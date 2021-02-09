package stack.revision;

import java.util.Map;
import java.util.Stack;

/*
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * "()[]{}"
 * "{[]}"
 * "([)]"
 * */
public class ValidParenthesesRevision2 {

    private static final Map<Character, Character> parenthesesPairs = Map.of('(', ')', '[', ']','{', '}');

    public static boolean isValid(String s) {
        Stack<Character> leftParentheses = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (parenthesesPairs.containsKey(s.charAt(i))){
                leftParentheses.push(s.charAt(i));
            }else {
                //takie porownanie zadziala s.charAt(i) != parenthesesPairs.get(leftParentheses.pop())
                //bo przy porownywaniu Character z char java unboxuje
                //https://stackoverflow.com/questions/36544223/comparing-primitive-to-wrapper-object-with-behaviour-unexplained
                if ( leftParentheses.isEmpty() || s.charAt(i) != parenthesesPairs.get(leftParentheses.pop())){
                    return false;
                }
            }
        }
        return leftParentheses.isEmpty();
    }
}
