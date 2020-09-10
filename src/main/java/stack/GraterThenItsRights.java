package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static java.util.stream.Collectors.toList;

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
public class GraterThenItsRights {

    public static int[] findGreaterThenTheirRightsStack(int[] numbers) {
        Stack<Integer> stackNumbers = new Stack<>();

        for (int number : numbers) {
            while (!stackNumbers.empty() && stackNumbers.peek() < number) {
                stackNumbers.pop();
            }
            stackNumbers.push(number);
        }

/*        stackNumbers.stream().collect(toList()).forEach(System.out::println);*///TODO how to convert list to primitive array

        int[] result = new int[stackNumbers.size()];
        int i = 0;
        while (!stackNumbers.empty()) {
            result[i] = stackNumbers.pop();
            i++;
        }
        return result;
    }


    public static List<Integer> findGreaterThenTheirRightsArray(int[] numbers) {
        List<Integer> result = new ArrayList<>();

        int maxTemp = Integer.MIN_VALUE;
        for(int i=numbers.length-1; i>=0;i--) {//TODO how to create a new array and add to it elements
            if(maxTemp < numbers[i]) {
                maxTemp = numbers[i];
                result.add(maxTemp);
            }
        }

        return result;
    }

}
