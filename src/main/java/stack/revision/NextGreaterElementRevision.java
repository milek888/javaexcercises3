package stack.revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
 * 496. Next Greater Element I
 *  https://leetcode.com/problems/next-greater-element-i/
 *  Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
    Output: [-1,3,-1]
 * Input: nums1 = [0,5,3,2,1,4], nums2 = [0,5,3,2,1,4,3]
   Output: [5,-1,4,4,4,-1]
 * */
public class NextGreaterElementRevision {

    public static int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> pairs = new HashMap<>();
        Stack<Integer> numbersStack = new Stack<>();

        for (int num : nums) {
            while (!numbersStack.isEmpty() && num > numbersStack.peek()) {
                pairs.put(numbersStack.pop(), num);
            }
            numbersStack.push(num);
        }

        while (!numbersStack.isEmpty()) {
            pairs.put(numbersStack.pop(), -1);
        }

        int[] result = new int[findNums.length];
        for (int i = 0; i < findNums.length; i++) {
            result[i] = pairs.get(findNums[i]);
        }

        return result;
    }
}
