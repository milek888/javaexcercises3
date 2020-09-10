package dynamicprogramming.other;

import java.util.Arrays;


/*
*   LeetCode 1314. Matrix Block Sum
*   https://leetcode.com/problems/matrix-block-sum/
* Tutaj rozwiazanie takie jak moje podane
*    https://leetcode.com/problems/matrix-block-sum/discuss/477041/Java-Prefix-sum-with-Picture-explain-Clean-code-O(m*n)
* TODO Inne rozwiazanie wyglada na ciekawe popatrzc
*    https://www.youtube.com/watch?v=KAIyAgn2UZU
* */
public class MatrixBlockSum {

    public int[][] matrixBlockSum(int[][] mat, int K) {
        int[][] cumulative = calculateCumulative(mat);
        int[][] result = new int[cumulative.length][cumulative[0].length];

        for (int i = 0; i < cumulative.length; i++) {
            for (int j = 0; j < cumulative[0].length; j++) {
                result[i][j] = calculateBlockSum(K, cumulative, i, j);
            }
        }

        return result;
    }

    private int calculateBlockSum(int K, int[][] cumulative, int i, int j) {

        int maxi = Integer.min(i + K, cumulative.length-1);
        int maxj = Integer.min(j + K, cumulative[0].length-1);
        int x = cumulative[maxi][maxj];

        int y = 0;
        if(i - K - 1 >= 0 ) {
           y = cumulative[i - K - 1][maxj];
        }

        int z = 0;
        if(j - K - 1 >= 0) {
            z = cumulative[maxi][j - K - 1];
        }

        int v = 0;
        if((i - K - 1 >= 0 ) && (j - K - 1 >= 0))  {
            v = cumulative[i - K - 1][j - K - 1];
        }

        return x - y - z + v;
    }

    private int[][] calculateCumulative(int[][] mat) {
        int[][] cumulative = Arrays.stream(mat)
                .map(int[]::clone)
                .toArray(int[][]::new);

        for (int i = 1; i < cumulative.length; i++) {
            cumulative[i][0] = cumulative[i][0] + cumulative[i - 1][0];
        }
        for (int j = 1; j < cumulative[0].length; j++) {
            cumulative[0][j] = cumulative[0][j] + cumulative[0][j - 1];
        }
        for (int i = 1; i < cumulative.length; i++) {
            for (int j = 1; j < cumulative[0].length; j++) {
                cumulative[i][j] = cumulative[i][j] + cumulative[i - 1][j] + (cumulative[i][j - 1] - cumulative[i - 1][j - 1]);
            }
        }

        return cumulative;
    }

}
/*
*
* `int[][] destination=Arrays.stream(source)
                    .map(a ->  Arrays.copyOf(a, a.length))
                    .toArray(int[][]::new);
*
*
* */