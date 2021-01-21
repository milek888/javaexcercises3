package stack.revision;

import java.util.Map;
import java.util.Stack;

/*
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * */
public class ValidParenthesesRevision {
    Map<String, String> parenthesesPairs;
    Map<String, String> parenthesesPairs2;//potrzebne do drugiego sposobu

    public ValidParenthesesRevision() {
        this.parenthesesPairs = Map.of("(", ")", "{", "}", "[", "]");
        this.parenthesesPairs2 = Map.of(")", "(", "]", "[", "}", "{");
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (String p : s.split("")) {
            if (parenthesesPairs.containsKey(p)) {
                stack.push(p);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                String leftParenthese = stack.pop();
                String pairedParenthese = parenthesesPairs.get(leftParenthese);
                if (!p.equals(pairedParenthese)) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public boolean isValid2(String s) {
        Stack<String> parenthesisStack = new Stack<>();
        for (String elem : s.split("")) {
            if (parenthesesPairs2.containsKey(elem)) {
           /*     if (parenthesesPairs.isEmpty()){
                    return false;
                }*///niepotrzebne bo tu bedziemy porownywac z nullem jak pusty stack if (!parenthesesPairs.get(elem).equals(elemFromStack)) i da false
                String elemFromStack = parenthesisStack.pop();
                if (!parenthesesPairs2.get(elem).equals(elemFromStack)){
                    return false;
                }
            } else {
                parenthesisStack.push(elem);
            }
        }
        return parenthesisStack.isEmpty();
    }
}
