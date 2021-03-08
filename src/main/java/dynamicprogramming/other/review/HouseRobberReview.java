package dynamicprogramming.other.review;

public class HouseRobberReview {

    public static int rob(int[] nums) {
        int prev = 0;
        int sum = 0;
        for (int num : nums) {
            int temp = sum;
            sum = Math.max(sum, prev + num);
            prev = temp;
        }
        return sum;
    }
}
