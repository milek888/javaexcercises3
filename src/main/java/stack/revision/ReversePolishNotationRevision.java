package stack.revision;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.regex.Pattern;

/*
* https://leetcode.com/problems/evaluate-reverse-polish-notation/
* https://stackoverflow.com/questions/7853502/how-to-convert-parse-from-string-to-char-in-java
* */
public class ReversePolishNotationRevision {

    private HashMap<String, BinaryOperator<Integer>> operations;
    private Set<String> operators;

    public ReversePolishNotationRevision() {
        this.operations = new HashMap<>();
        operations.put("+", Integer::sum);
        operations.put("-", (Integer x, Integer y) -> x - y);
        operations.put("*", (Integer x, Integer y) -> x * y);
        operations.put("/", (Integer x, Integer y) -> x / y);

        this.operators = Set.of("+", "-", "*", "/");

        //Potrzebne do drugiego sposobu
        this.functions = Map.of("+", Double::sum,
                "-", (x, y) -> x - y,
                "*", (x, y) -> x * y,
                "/", (x, y) -> x / y);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> arguments = new Stack<>();

        for (String token : tokens) {
            if (operators.contains(token)) {
                Integer arg1 = arguments.pop();
                Integer arg2 = arguments.pop();
                BinaryOperator<Integer> operation = operations.get(token);
                arguments.push(operation.apply(arg2, arg1));//wazne tu argumenty maja byc w odwrotnej kolejnosci sciagania
            } else {
                arguments.push(Integer.valueOf(token));
            }

        }
        return arguments.pop();
    }

    /*
    * 2 sposob
    * */
    private final Map<String, BinaryOperator<Double>> functions;
    private final Stack<Double> operands = new Stack<>();
    private final String decimalPattern = "([0-9]*)\\.([0-9]*)";

    public double evalRPN2(String[] tokens) {

        for (int i = 0; i < tokens.length; i++) {
            if (Pattern.matches(decimalPattern, tokens[i])) {
                operands.push(Double.valueOf(tokens[i]));
            } else {
                double arg1 = operands.pop();
                double arg2 = operands.pop();
                double result = functions.get(tokens[i]).apply(arg2, arg1);//wazne tu argumenty maja byc w odwrotnej kolejnosci sciagania
                operands.push(result);
            }
        }
        return operands.pop();
    }

}
