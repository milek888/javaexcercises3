package dynamicprogramming.other.painthouse;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static dynamicprogramming.other.painthouse.PaintHouseValidator.hasCostsAllRowsNotEmpty;
import static dynamicprogramming.other.painthouse.PaintHouseValidator.isCostNotEmpty;
import static dynamicprogramming.other.painthouse.PaintHouseValidator.noNegativeCosts;


/*
 * LeetCode 256. Paint House
 * https://leetcode.com/problems/paint-house/
 */
//TODO What to do for such cases: int[][] costs = {{},{}} OR {{1,2,3}, {} } OR {{},{1,2,3} } OR {{1,2,3}, {},{1,2,3} }
//OR negative numbers {{-1,2,3} ,{1,2,3} } OR Brakujace wartosci {{1,3} ,{1,2,3} }
//TODO sporobowac dopisac w metodzie reguly walidacyje Validatorem Vitalija albo tym walidatorem https://www.youtube.com/watch?v=VRpHdSFWGPs i powyrzucac wyjatki
//i przetestowac wyrzucenie wyjatkow w tescie

public class PaintHouse {
    private int[][] costs;
    private Map<String, Integer> calculatedCostColor = new HashMap<>();

//-----------------------------------------------rozwiazanie top down--------------------------------

    public int minCost(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }
        this.costs = costs;
        int n = costs.length;
        return IntStream.of(costColor(n, 0), costColor(n, 1), costColor(n, 2))
                .min()
                .orElse(0);
    }

    private int costColor(int n, int color) {
        if (n == 1) {
            return costs[0][color];
        }

        Integer result = calculatedCostColor.get(getKeyHouseColor(n, color));
        if (result != null) {
            return result;
        }

        if (color == 0) {
            result = costs[n - 1][0] + Integer.min(costColor(n - 1, 1), costColor(n - 1, 2));
            System.out.println("");
        }
        if (color == 1) {
            result = costs[n - 1][1] + Integer.min(costColor(n - 1, 0), costColor(n - 1, 2));
            System.out.println("");
        }
        if (color == 2) {
            result = costs[n - 1][2] + Integer.min(costColor(n - 1, 0), costColor(n - 1, 1));
            System.out.println("");
        }
        calculatedCostColor.put(getKeyHouseColor(n, color), result);
        return result;
    }

    private String getKeyHouseColor(int n, int color) {
        return n + "-" + color;
    }


//-----------------------------------------------rozwiazanie bottom up--------------------------------

    public int minCostIterative(int[][] costs) {
        if (costs == null || costs.length == 0 || costs[0].length == 0) {
            return 0;
        }

        int n = costs.length-1;
        for(int i =1; i<=n;i++){
            costs[i][0] += Integer.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Integer.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Integer.min(costs[i-1][0], costs[i-1][1]);
        }

         int result = IntStream.of(costs[n][0],costs[n][1],costs[n][2])
                .min()
                .orElse(0);
        return result;
    }

    //-------------------------------------------rozwiazanie bottom up rozszerzone o walidacje------------

    public int minCostIterativeWithValidation(int[][] costs) {//TODO tests exception
        ValidaionResult validaionResult = PaintHouseValidator.isCostNotNull()
                .and(isCostNotEmpty())
                .and(hasCostsAllRowsNotEmpty())
                .and(noNegativeCosts())
                .apply(costs);

        if(validaionResult != ValidaionResult.SUCCESS) {
            throw new PaintHouseValidationException(validaionResult.toString());
        }

    /*    PaintHouseValidator.isCostNotNull().andThen(isCostNotEmpty()).apply(costs);//TODO  ??*/

        int n = costs.length-1;
        for(int i =1; i<=n;i++){
            costs[i][0] += Integer.min(costs[i-1][1], costs[i-1][2]);
            costs[i][1] += Integer.min(costs[i-1][0], costs[i-1][2]);
            costs[i][2] += Integer.min(costs[i-1][0], costs[i-1][1]);
        }

        int result = IntStream.of(costs[n][0],costs[n][1],costs[n][2])
                .min()
                .orElse(0);
        return result;
    }

    /*public int minCost2(int[][] costs) {//TODO it doesn't work
        if (costs == null || costs[0].length == 0) {
            return 0;
        }
        int homeNumbers = costs[0].length;
        int[][] calculatedCosts = new int[homeNumbers][2];

        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        if (homeNumbers == 1) {
            for (int i = 0; i < 3; i++) {
                if (min > costs[0][i]) {
                    min = costs[0][i];
                    minIndex = i;
                }
            }
            calculatedCosts[0][0] = minIndex;
            calculatedCosts[0][1] = min;
        }
        if (homeNumbers == 2) {
            for (int i = 0; i < 3; i++) {
                if (i != minIndex && min > costs[1][i]) {
                    min = costs[1][i];
                    minIndex = i;
                }
            }
            calculatedCosts[1][0] = minIndex;
            calculatedCosts[1][1] = min + calculatedCosts[0][1];
        }
        return 0;
    }
*/
}
