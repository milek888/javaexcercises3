package java8.other;

import java.util.HashMap;
import java.util.Map;

/*
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/
 * */
public class FindAllPairsSumToK {

    /*
    * Input: nums = [2,7,11,15], target = 9
      Output: [0,1]
    * */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> substractsIndexes = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            substractsIndexes.put(target - nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            Integer index = substractsIndexes.get(i);
            if (index != null){
                return new int[]{nums[i], nums[index]};
            }
        }
        return null;
    }
}
