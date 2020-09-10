package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.DoubleBinaryOperator;

public class ReversePolishNotation {
    private Stack<String> stack = new Stack<>();
    private final Map<String, DoubleBinaryOperator> operators;

    public ReversePolishNotation() {
        this.stack = new Stack<>();
        this.operators = Map.of("+", Double::sum,
                "-", (double x,double y) -> x-y,
                "*", (double x,double y) -> x*y,
                "/", (double x,double y) -> x/y);
    }

    //(2+3)*5 => 2 3 + 5 *
    public double calculate(String expression) {

        for(String arg: expression.split(" ")) {
            if(arg.matches("\\d+")) {
                stack.push(arg);
            } else {
                double leftArg = Double.parseDouble(stack.pop());
                double rightArg = Double.parseDouble(stack.pop());
                double result = operators.get(arg).applyAsDouble(rightArg, leftArg);
                stack.push(String.valueOf(result));
            }
        }
        return Double.parseDouble(stack.pop());
    }


}
