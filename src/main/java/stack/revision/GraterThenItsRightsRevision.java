package stack.revision;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * https://www.techiedelight.com/find-elements-array-greater-than-elements-right/
 * Find all elements in an array that are greater of all elements present on their right
 * Input: {10,4,6,3,5}
 * 10,6,5
 * Because:
 *     10 is greater then 4,6,3,5
 *      6 is greater then 3,5
 *      5 has no elements on right so it's warunek pusto spelniony
 * */
public class GraterThenItsRightsRevision {

    public static int[] findGreaterThenTheirRightsStack(int[] numbers) {
        Stack<Integer> numbersStack = new Stack<>();
        for (int number : numbers) {
            while (!numbersStack.isEmpty() && numbersStack.peek() < number) {
                numbersStack.pop();
            }
            numbersStack.push(number);
        }
        int[] result = new int[numbersStack.size()];
        int i = numbersStack.size()-1;
        while (!numbersStack.isEmpty()) {
            result[i] = numbersStack.pop();
            i--;//iterowanie od najwiekszej do najmniejszej zapobiega odwroconej kolejnosci
        }
        return result;
    }

    public static List<Integer> findGreaterThenTheirRightsArray(int[] numbers) {
        int tempMax = Integer.MIN_VALUE;
        LinkedList<Integer> result = new LinkedList<>();

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] > tempMax) {
                tempMax = numbers[i];
                result.addFirst(numbers[i]);//wazne dodajemy na poczatek listy zeby nie miec odwroconej kolejnosci
            }
        }
        return result;
    }


}
