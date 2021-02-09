package trees.bst.revision;

import trees.bst.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * LeetCode 113. Path Sum II
 * https://leetcode.com/problems/path-sum-ii/
 *Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's
 * sum equals targetSum.
 * */
public class PathSumIIRevision {//TODO napisac testy do tego i spr czy dziala
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        int currentSum = 0;
        LinkedList<Integer> currentPath = new LinkedList<>();
        pathSumHelper(root, sum, currentSum, paths, currentPath);
        return paths;
    }

    private static void pathSumHelper(TreeNode current, int sum, int currentSum, List<List<Integer>> paths, LinkedList<Integer> currentPath) {
        if (current == null) {
            return;
        }
        currentSum += current.val;
        currentPath.add(current.val);
        if (current.left == null && current.right == null && currentSum == sum){
            paths.add(currentPath);
        }
        pathSumHelper(current.left, sum, currentSum, paths, currentPath);
     /*   currentPath.removeLast();*///TODO zastanowic sie dlaczego tylko raz usuwamy a nie 2 razy
        pathSumHelper(current.right, sum, currentSum, paths, currentPath);
        currentPath.removeLast();
    }
}
