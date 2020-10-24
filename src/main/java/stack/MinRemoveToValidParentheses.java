package stack;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/*
* 1249. Minimum Remove to Make Valid Parentheses
* https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
* */
public class MinRemoveToValidParentheses {

    public static String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> indexesToRemove = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                if ( !stack.isEmpty()) {
                    stack.pop();
                } else {
                    indexesToRemove.add(i);
                }
            }
        }

        while (!stack.isEmpty()) {
            indexesToRemove.add(stack.pop());
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!indexesToRemove.contains(i)) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
