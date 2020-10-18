package stack.revision;

import java.util.HashMap;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;

/*
* https://leetcode.com/problems/evaluate-reverse-polish-notation/
* https://stackoverflow.com/questions/7853502/how-to-convert-parse-from-string-to-char-in-java
* */
public class ReversePolishNotationRevision {

    private HashMap<String, BiFunction<Integer, Integer, Integer>> operations;
    private Set<String> operators;

    public ReversePolishNotationRevision() {
        this.operations = new HashMap<>();
        operations.put("+", Integer::sum);
        operations.put("-", (Integer x, Integer y) -> x - y);
        operations.put("*", (Integer x, Integer y) -> x * y);
        operations.put("/", (Integer x, Integer y) -> x / y);

        this.operators = Set.of("+", "-", "*", "/");
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> arguments = new Stack<>();

        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer arg1 = arguments.pop();
                Integer arg2 = arguments.pop();
                BiFunction<Integer, Integer, Integer> operation = operations.get(token);
                arguments.push(operation.apply(arg2, arg1));
            } else {
                arguments.push(Integer.valueOf(token));
            }

        }
        return arguments.pop();
    }

}
