import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sortowanie.CountingSort;
import stack.ReversePolishNotation;
import stack.SimplifyPath;
import stack.SimplifyPathCorrect;
import stack.ValidParentheses;

import java.util.Arrays;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {

     /*   StringValidator stringValidator = new StringValidator();
        boolean result = stringValidator.validateString("cabcmaagmggcaccbcc");
        logger.debug("result = " + result);*/

        ReversePolishNotation polishNotation = new ReversePolishNotation();
/*        //(2+3)*5 => 2 3 + 5 *
        double result = polishNotation.calculate("2 3 + 5 *");
        System.out.println("(2+3)*5 => 2 3 + 5 *  = " + result);*/

        //((2+7)/3+(14-3)*4)/2   =>    2 7 + 3 / 14 3 - 4 * + 2 /
     /*   double result2 = polishNotation.calculate("2 7 + 3 / 14 3 - 4 * + 2 /");
        System.out.println("2 7 + 3 / 14 3 - 4 * + 2 /  = " + result2);*/

        System.out.println("---------------------LeetCode ValidParentheses--------------------------");

/*        ValidParentheses validParentheses = new ValidParentheses();
        boolean valid1 = validParentheses.isValid("[");
        System.out.println("valid1 = " + valid1);*/
        //"()[]{}"
        //"()"
        //"{[]}"
        //"([)]"

        System.out.println("---------------------Counting sort--------------------------");

    /*    int[] numbers = { 6, 3, 6, 1, 4, 9, 0, 1, 8, 2, 6, 4, 9, 3, 7, 5, 9, 2, 7, 3, 2, 4, 1, 8, 7, 0, 8, 5, 8, 3, 6, 2, 5, 3};
        int[] sortedNumbers = CountingSort.sort(numbers);
        Arrays.stream(sortedNumbers).forEach(System.out::print);*/

        System.out.println("---------------------LeetCode 71. Simplify Path--------------------------");

       /* SimplifyPath.calculateSimplePath("/a/../../b/../c//.//");*/
        SimplifyPathCorrect simplifyPathCorrect = new SimplifyPathCorrect();
        String path = simplifyPathCorrect.calculateSimplePath("/a/../../b/../c//.//");

        System.out.println("--------------------------------------------------------------------------------------");
    }
}
