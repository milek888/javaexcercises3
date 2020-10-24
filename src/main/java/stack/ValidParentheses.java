package stack;

import java.util.Map;
import java.util.Stack;

/*
* 20. Valid Parentheses
* https://leetcode.com/problems/valid-parentheses/
* */
public class ValidParentheses {
    private Stack<String> stackParentheses;
    private final Map<String, String> mapParentheses;

    public ValidParentheses() {
        stackParentheses = new Stack<>();
        mapParentheses = Map.of("(", ")", "{", "}", "[", "]");
    }

    public boolean isValid(String s) {
        if(s == null || s.isEmpty()) {
            return true;
        }
        for (String parenthese : s.split("")) {
            if (mapParentheses.containsKey(parenthese)) {
                stackParentheses.push(parenthese);
            } else {
                if(stackParentheses.isEmpty()) {
                    return false;
                }
                String rightParenthese = mapParentheses.get(stackParentheses.pop());
                if (!parenthese.equals(rightParenthese)) {
                    return false;
                }
            }
        }
        return stackParentheses.isEmpty();
    }
}
