package trees.bst.revision;

import trees.bst.model.TreeNode;

/*
* LeetCode 112. Path Sum
  https://leetcode.com/problems/path-sum/
* */
public class PathSumRevision {

    public static boolean hasPathSum(TreeNode root, int sum) {
        int pathSum = 0;
        return hasPathSumRecursive(root, sum, pathSum);
    }

    public static boolean hasPathSumRecursive(TreeNode curr, int sum, Integer pathSum) {
        if (curr == null) {
            return false;
        }
        pathSum += curr.val;
        if (curr.left == null && curr.right == null && pathSum == sum) {
            return true;
        }
        return hasPathSumRecursive(curr.left, sum, pathSum) || hasPathSumRecursive(curr.right, sum, pathSum);
    }

}
