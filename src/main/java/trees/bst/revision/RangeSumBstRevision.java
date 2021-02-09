package trees.bst.revision;


import trees.bst.model.TreeNode;

import java.util.concurrent.atomic.AtomicInteger;

/*
* 938. Range Sum of BST
  https://leetcode.com/problems/range-sum-of-bst/
  * Given the root node of a binary search tree, return the sum of values of all nodes with a value in the range [low, high].
* */
public class RangeSumBstRevision {
    Integer currSum = 0;
    public  int rangeSumBST(TreeNode root, int L, int R) {
        calculateSum(root, L, R);
        return currSum;
    }

    public  void calculateSum(TreeNode curr, int L, int R) {
        if (curr == null) {
            return;
        }
        if (curr.val >= L && curr.val <= R) {
            currSum += curr.val;
        }
        if (curr.val > L) {
            calculateSum(curr.left, L, R);
        }
        if (curr.val < R) {
            calculateSum(curr.right, L, R);
        }
    }
}

/*
 * Policzyc sume na danym poziomie, wykorzystac counter
 *  1) wersja rekurencyjna
 *  2) wersja ze stosem
 * */

