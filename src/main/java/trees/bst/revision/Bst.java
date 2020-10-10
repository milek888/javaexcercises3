package trees.bst.revision;

import java.util.HashMap;

public class Bst {


    //LeetCode 437. Path Sum III
    //https://leetcode.com/problems/path-sum-iii/
    public static int pathSum(Node root, int target) {
        HashMap<Integer, Integer> prefixSums = new HashMap<>();
        int counter = 0;//TODO alternatywnie zamiast countera tak przekazywac przez parametr i zwracac mozna zmienna instancyjna AtomicInteger
        int currSum = 0;
        return pathSumHelper(root, target,  prefixSums, counter, currSum);
    }

    private static int pathSumHelper(Node root, int target, HashMap<Integer, Integer> prefixSums, int counter, int currSum) {
        if (root == null) {
            return counter;
        }
        currSum += root.val;
        if (currSum == target) {
            counter++;
        }
        counter += prefixSums.getOrDefault(currSum - target, 0);
        prefixSums.merge(currSum, 1, Integer::sum);

        counter = pathSumHelper(root.left, target, prefixSums, counter, currSum);
        counter = pathSumHelper(root.right, target, prefixSums, counter, currSum);
        prefixSums.merge(currSum, 0, (v1, v2) -> v1 - 1);//alternatywnie mozna tak //prefixSums.computeIfPresent(currSum, (k, v) -> v - 1);
        return counter;
    }

    public static Node sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private static Node createTree(int[] nums, int left, int right) {
        Node root = null;
        if (left <= right) {
            int mid = (left + right) / 2;
            Node leftNode = createTree(nums, left, mid - 1);
            Node rightNode = createTree(nums, mid + 1, right);
            root = new Node(nums[mid], leftNode, rightNode);
        }
        return root;
    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
