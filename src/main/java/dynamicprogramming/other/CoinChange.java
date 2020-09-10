package dynamicprogramming.other;


import java.util.Arrays;

/* Leet code 322. Coin Change
 *  Fajne wytlumaczenie https://www.codesdope.com/course/algorithms-coin-change/
 *  https://www.codesdope.com/course/algorithms-coin-change/
 * */
public class CoinChange {

    //bottom up dynamic programming
    public int coinChangeBottomUp(int[] coins, int amount) {
        int min = Integer.MAX_VALUE;
        int[] changes = new int[amount + 1];//Initial array elements are initialized to default vars. https://stackoverflow.com/questions/3426843/what-is-the-default-initialization-of-an-array-in-java

        changes[0] = 0;
        for (int j = 1; j <= amount; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] <= j) {
                    changes[j] = Integer.min(min, 1 + changes[j - coins[i]]);
                }
            }
        }
        return changes[amount];
    }

    public int coinChangeTopDownMain(int[] coins, int amount) {
        int[] changes = new int[amount + 1];
        Arrays.fill(changes, Integer.MAX_VALUE);
        return coinChangeTopDown(coins, amount, changes);
    }

    //top down dynamic programming
    public int coinChangeTopDown(int[] coins, int amount, int[] changes) {
        if (amount == 0) {
            return 0;
        }
        if(changes[amount] != Integer.MAX_VALUE) {
            return changes[amount];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] <= amount) {
                min = Integer.min(min, 1 + coinChangeTopDown(coins, amount - coins[i], changes));
            }
        }
        changes[amount] = min;

        return min;
    }

}
