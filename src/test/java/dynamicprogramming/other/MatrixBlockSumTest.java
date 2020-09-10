package dynamicprogramming.other;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class MatrixBlockSumTest {

    MatrixBlockSum matrixBlockSum;

    @BeforeEach
    void setUp() {
        matrixBlockSum = new MatrixBlockSum();
    }

    @Test
    void matrixBlockSum() {
        int[][] arr = {{1, 1, 1, 1},
                       {2, 2, 2, 2},
                       {3, 3, 3, 3}};

        int[][] actualAnswer = matrixBlockSum.matrixBlockSum(arr, 1);
        int[][] expectedAnswer = {{6,9,9,6},
                {12,18,18,12},
                {10,15,15,10}};
        assertArrayEquals(actualAnswer, expectedAnswer);
    }

    @Test
    void matrixBlockSum2() {
        int[][] arr = {{1, 2, 3},
                       {4, 5, 6},
                       {7, 8, 9}};

        int[][] actualAnswer  = matrixBlockSum.matrixBlockSum(arr, 1);
        int[][] expectedAnswer = {{12,21,16},
                                  {27,45,33},
                                  {24,39,28}};
        assertArrayEquals(actualAnswer, expectedAnswer);
    }

}