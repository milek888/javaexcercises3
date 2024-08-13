package dynamicprogramming.other;


import org.apache.commons.lang3.ArrayUtils;

import java.util.stream.IntStream;

import static org.apache.commons.lang3.ArrayUtils.*;

/*
https://leetcode.com/problems/house-robber/description/
* f(k) = max(f(k – 2) + nums[k], f(k – 1))
* */
public class HouseRobber {

    public static int rob(int[] nums) {
        if (isEmpty(nums)) {
            throw new RuntimeException("empty numbers array exception");
        }

        int prev = 0;
        int result = 0;
        for (int num : nums) {
            int temp = result;
            result = Integer.max(prev + num, result);
            prev = temp;
        }
        return result;
    }

}
