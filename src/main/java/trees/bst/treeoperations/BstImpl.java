package trees.bst.treeoperations;

import java.util.Stack;

public class BstImpl implements Bst {

    int rangeSum;//TODO figure out something else then instance var
    private TreeNode root;

    public BstImpl() {
    }

    public BstImpl(TreeNode root) {
        this.root = root;
    }

    //--------------------------------------------------98. Validate Binary Search Tree----------------------------------------------------------------

    //Leetcode 98. Validate Binary Search Tree
    //https://leetcode.com/problems/validate-binary-search-tree/
    //https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    // Returns true if given tree is BST.
    static boolean isBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        if (lower != null && node.val <= lower)
            return false;
        if (upper != null && node.val >= upper)
            return false;

        return isBST(node.left, lower, node.val) &&//kazde wejscie do lewego wezla (i tylko wejscie do lewego wezla) zmienia gorny limit <=> wszystkie wezly podrzewamusza byc mniejsze od gornego limitu
                isBST(node.right, node.val, upper);//kazde wejscie do prawego wezla (i tylko wejscie do prawego wezla) zmienia dolny limit <=> wszystkie wezly w podrzewie musza byc wieksze od dolnego limit
    }

    //--------------------------------------------------108. Convert Sorted Array----------------------------------------------------------------

    //LeetCode 108. Convert Sorted Array to Binary Search Tree
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    private TreeNode createTree(int[] nums, int left, int right) {
        TreeNode root = null;
        if (left <= right) {
            int mid = (left + right) / 2;
            TreeNode leftNode = createTree(nums, left, mid - 1);
            TreeNode rightNode = createTree(nums, mid + 1, right);
            root = new TreeNode(nums[mid], leftNode, rightNode);
        }
        return root;
    }

    //--------------------------------------------------------Search BST----------------------------------------------------------

    //https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
    @Override
    public TreeNode search(TreeNode node, int val) {

        if (node == null || node.val == val) {
            return node;
        }
        if (node.val > val) {
            return search(node.left, val);
        }
        return search(node.right, val);
    }

    //----------------------------------------------------Insert to BST--------------------------------------------------------------

    @Override
    public void insert(int val) {
        insertUtil(root, val);
    }

    //https://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
    private TreeNode insertUtil(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val, null, null);
        }
        if (node.val > val) {
            node.left = insertUtil(node.left, val);
        } else {
            node.right = insertUtil(node.right, val);
        }
        /* return the (unchanged) node pointer*/
        return node;
    }

    //---------------------------------------------------------LeetCode 112. Path Sum---------------------------------------------------------

    //-----------------moje rozwiazanie------------------
    //LeetCode 112. Path Sum
    //https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int sum) {
        int currSum = 0;
        return hasPathSumUtil(root, sum, currSum);
    }

    private boolean hasPathSumUtil(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return false;
        }

        curSum += root.val;
        if (root.left == null && root.right == null && curSum == sum) {
            return true;
        }

        return hasPathSumUtil(root.left, sum, curSum) || hasPathSumUtil(root.right, sum, curSum);
    }

    //--------------rozwiazanie oryginalne z LeetCode--------
    public boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum2(root.left, sum) || hasPathSum2(root.right, sum);
    }

    //---------------rozwiazanie ze stosem-----------------
    public boolean hasPathSumStack(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int curSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        TreeNode current = root;

        stack.push(current);
        sumStack.push(current.val);

        while (!stack.isEmpty()) {

            current = stack.pop();
            curSum = sumStack.pop();

            if (current.left == null && current.right == null && curSum == sum) {
                return true;
            }
            if (current.right != null) {
                stack.push(current.right);
                sumStack.push(curSum + current.right.val);
            }
            if (current.left != null) {
                stack.push(current.left);
                sumStack.push(curSum + current.left.val);
            }
        }
        return false;
    }

   //-----------------------------------------------------------LeetCode 113. Path Sum II-------------------------------------------------------------------------

    /*
    * LeetCode 113. Path Sum II
    * https://leetcode.com/problems/path-sum-ii/
    *
    * */

    //------------------------------------------------------delete val in BST------------------------------------------------------------

    @Override
    public void delete(int val) {

    }

    //------------------------------------------------------------Range Sum of BST------------------------------------------------------

    //938. Range Sum of BST
    //https://leetcode.com/problems/range-sum-of-bst/
    public int rangeSumBST(TreeNode current, int min, int max) {
        rangeSum = 0;
        preorderRange(current, min, max);
        return rangeSum;
    }

    private void preorderRange(TreeNode current, int min, int max) {
        if (current == null) {
            return;
        }
        if (current.val >= min && current.val <= max) {
            rangeSum += current.val;
        }
        if (current.val > min) {
            preorderRange(current.left, min, max);
        }
        if (current.val < max) {
            preorderRange(current.right, min, max);
        }
    }

    //---------------------------------------------------------226. Invert Binary Tree---------------------------------------------------------
    /*
     * 226. Invert Binary Tree -> It doesn't have to be BST. It's binary tree
     * https://leetcode.com/problems/invert-binary-tree/
     *
     * */
    public TreeNode invertTree(TreeNode root) {
        invertTreeHelper(root);
        return root;
    }

    private void invertTreeHelper(TreeNode root) {
        if (root == null) {
            return;
        }
        invertTreeHelper(root.left);
        invertTreeHelper(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = temp;
    }

    //------------------------------------------------------------------------------------------------------------------

    public TreeNode initTree2() {
     /*   TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(10);
        TreeNode treeNode3 = new TreeNode(7, treeNode5, treeNode6);
        TreeNode treeNode4 = new TreeNode(12);*/
        TreeNode treeNode2 = new TreeNode(11/*, treeNode3, treeNode4*/);
        TreeNode treeNode4 = new TreeNode(60);
        TreeNode treeNode5 = new TreeNode(90);
        TreeNode treeNode3 = new TreeNode(70, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(13, treeNode2, treeNode3);
        return treeNode1;
    }

    //----------------------------------------------------
    /*
     * Due to it's inner class we dont't have to use getters and setters in methods like insert, search etc
     * This getters and setters caused implementation less readable. Now I can use directly private fields left, rights,
     *  val
     * */
    public class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
