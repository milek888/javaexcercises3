package other;

/*
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water/
 * */
public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        if(height == null) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (left < right) {
            int currentArea = Integer.min(height[left], height[right])*(right-left);
            max = Integer.max(max, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }

}
