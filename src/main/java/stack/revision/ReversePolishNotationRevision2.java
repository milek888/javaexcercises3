package stack.revision;

import java.util.Map;
import java.util.Stack;
import java.util.function.BinaryOperator;

public class ReversePolishNotationRevision2 {

    private static final Map<String, BinaryOperator<Double>> operations = Map.of("+", Double::sum,
            "-", (x, y) -> x - y,
            "*", (x, y) -> x * y,
            "/", (x, y) -> x / y);

    public static double evalRPN(String[] tokens) {
        Stack<String> stackTokens = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (!operations.containsKey(tokens[i])){
                stackTokens.push(tokens[i]);
            } else {
                double arg2 = Double.parseDouble(stackTokens.pop());
                double arg1 = Double.parseDouble(stackTokens.pop());
                double result = operations.get(tokens[i]).apply(arg1, arg2);
                stackTokens.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(stackTokens.pop());
    }

}
