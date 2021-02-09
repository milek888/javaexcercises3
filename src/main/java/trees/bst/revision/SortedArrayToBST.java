package trees.bst.revision;

import trees.bst.model.TreeNode;

/*
*  LeetCode 108. Convert Sorted Array to Binary Search Tree
   https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
* */
public class SortedArrayToBST {

    public static TreeNode convertSortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private static TreeNode createTree(int[] nums, int left, int right) {
        TreeNode node = null;
        if (left <= right) {
            int mid = (left + right) / 2;
            node = new TreeNode(nums[mid]);
            node.left = createTree(nums, left, mid - 1);
            node.right = createTree(nums, mid + 1, right);
        }
        return node;
    }
}




