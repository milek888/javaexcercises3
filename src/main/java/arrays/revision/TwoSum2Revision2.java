package arrays.revision;

public class TwoSum2Revision2 {

    public static int[] twoSum1(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[2];
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                return new int[]{i, j};
            }
            if (numbers[i] + numbers[j] > target) {
                j--;
            } else  {
                i++;
            }
        }
        return new int[2];
    }
}
