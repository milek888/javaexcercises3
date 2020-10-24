package stack.revision;

import java.util.Map;
import java.util.Stack;

/*
 * 20. Valid Parentheses
 * https://leetcode.com/problems/valid-parentheses/
 * */
public class ValidParenthesesRevision {
    Map<String, String> parenthesesPairs;

    public ValidParenthesesRevision() {
        this.parenthesesPairs = Map.of("(", ")", "{", "}", "[", "]");
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


}
