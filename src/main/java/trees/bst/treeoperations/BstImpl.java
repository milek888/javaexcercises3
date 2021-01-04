package trees.bst.treeoperations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BstImpl implements Bst {

    int rangeSum;//TODO figure out something else then instance var
    //--------------------------------------------------------LeetCode 437. Path Sum III-------------------------------------------------
    /*
     *LeetCode 437. Path Sum III
     * https://leetcode.com/problems/path-sum-iii/
     * */
    int counter;
    private TreeNode root;

    public BstImpl() {
    }

    //--------------------------------------------------98. Validate Binary Search Tree----------------------------------------------------------------

    public BstImpl(TreeNode root) {
        this.root = root;
    }

    //--------------------------------------------------108. Convert Sorted Array----------------------------------------------------------------

    //Leetcode 98. Validate Binary Search Tree
    //https://leetcode.com/problems/validate-binary-search-tree/
    //https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
    // Returns true if given tree is BST.
    static boolean isBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        //2) A tutaj ↓ sprawdzamy po wejsciu.  Te dwa ify to sprawdzamy warunki ze wezel podrewa jest  dolny limit < wezel < od gornego limitu. Jesli ktorys z tych warunkow nie spelniony zwracamy false
        if (lower != null && node.val <= lower)
            return false;
        if (upper != null && node.val >= upper)
            return false;              //1) tutaj ustawiamy limity i wchodzimy
        //↓
        return isBST(node.left, lower, node.val) &&//kazde wejscie do lewego wezla (i tylko wejscie do lewego wezla) zmienia gorny limit <=> wszystkie wezly podrzewamusza byc mniejsze od gornego limitu
                isBST(node.right, node.val, upper);//kazde wejscie do prawego wezla (i tylko wejscie do prawego wezla) zmienia dolny limit <=> wszystkie wezly w podrzewie musza byc wieksze od dolnego limit
    }


    //--------------------------------------------------------Search BST----------------------------------------------------------


    //----------------------------------------------------Insert to BST--------------------------------------------------------------


    //---------------------------------------------------------LeetCode 112. Path Sum---------------------------------------------------------


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

    //-----------------------------------------------------------LeetCode 113. Path Sum II-------------------------------------------------------------------------

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

    //---------------rozwiazanie ze stosem Preorder-----------------
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

    //---------------rozwiazanie ze stosem Inorder-----------------

    public boolean hasPathSumStackInorder(TreeNode root, int sum) {
        Stack<Integer> pathSums = new Stack<>();
        int currSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode next = root;

        while (!stack.isEmpty() || next != null) {
            if (next != null) {
                stack.push(next);
                currSum += next.val;
                pathSums.push(currSum);
                next = next.left;
            } else {
                TreeNode node = stack.pop();
                if (node.left == null && node.right == null && currSum == sum) {
                    return true;
                }
                currSum -= node.val;
                System.out.println(node.val);
                next = node.right;

            }
        }
        return false;
    }

    //------------------------------------------------------------Range Sum of BST------------------------------------------------------

    /*
     * LeetCode 113. Path Sum II
     * https://leetcode.com/problems/path-sum-ii/
     *
     * */
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        int curSum = 0;
        LinkedList<Integer> path = new LinkedList<>();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        return pathSumUtil(root, sum, paths, curSum, path);
    }

    private ArrayList<ArrayList<Integer>> pathSumUtil(TreeNode root, int sum, ArrayList<ArrayList<Integer>> paths, int curSum, LinkedList<Integer> path) {
        if (root == null) {
            return paths;
        }

        curSum += root.val;
        path.add(root.val);
        if (root.left == null && root.right == null && curSum == sum) {
            paths.add(new ArrayList<>(path));
        }

        pathSumUtil(root.left, sum, paths, curSum, path);
        pathSumUtil(root.right, sum, paths, curSum, path);
        path.remove(path.size() - 1);
        return paths;
    }

    //------------------------------------------------------------Path Sum III------------------------------------------------------
    /*
    * 437. Path Sum III
    * https://leetcode.com/problems/path-sum-iii/
    * */
    public int pathSum3(TreeNode root, int sum) {
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        int currentSum = 0;
        recursivePreOrder(root, sum, frequencies, currentSum);
        return counter;
    }

    private int recursivePreOrder(TreeNode root, int sum, HashMap<Integer, Integer> frequencies, int currentSum) {
        if (root == null) {
            return counter;
        }
        System.out.println(root.val);
        currentSum += root.val;
        if (currentSum == sum) {
            counter++;
        }

        counter += frequencies.getOrDefault(currentSum - sum, 0);
        frequencies.merge(currentSum, 1, Integer::sum);

        recursivePreOrder(root.left, sum, frequencies, currentSum);
        recursivePreOrder(root.right, sum, frequencies, currentSum);
        frequencies.put(currentSum, frequencies.get(currentSum) - 1);

        return counter;
    }

    //-------------------------------------------------------------------------------------------------------------------------

    @Override
    public void delete(int val) {

    }

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

    //construct balanced bst from given keys
    // https://www.techiedelight.com/construct-balanced-bst-given-keys/
    public TreeNode anyArrayToBST(int[] keys) {
        Arrays.sort(keys); //TODO <= remember about it
        return anyArrayToBSTHelper(keys, 0, keys.length - 1);
    }

    private TreeNode anyArrayToBSTHelper(int[] keys, int left, int right) {
        //for edge cases
        TreeNode root = new TreeNode(0);
        if (keys == null || keys.length == 0) {
            return root;
        }

        int mid = (left + right) / 2;
        root = new TreeNode(keys[mid]);
        if (left <= mid - 1) {
            root.left = anyArrayToBSTHelper(keys, left, mid - 1);
        }
        if (right >= mid + 1) {
            root.right = anyArrayToBSTHelper(keys, mid + 1, right);
        }

        return root;
    }

//----------------------------------------------------------------------------Powtorka---------------------------------------------------------------------
//---------------------------------------------------------------------------------------------------------------------------------------------------------

    //--------------Powtorka cd. pre, in, postorder recusively----------------

    public void revisionPreorderRecursive(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        revisionPreorderRecursive(root.left);
        revisionPreorderRecursive(root.right);
    }

    public void revisionInorderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        revisionInorderRecursive(node.left);
        System.out.print(node.val + " ");
        revisionInorderRecursive(node.right);
    }

    public void revisionPostorderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        revisionPostorderRecursive(node.left);
        revisionPostorderRecursive(node.right);
        System.out.print(node.val + " ");
    }

    //--------------Powtorka cd. pre, in, postorder with stack----------------

    public void revisionPreorderWithStack(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode currNode = root;
        Stack<TreeNode> stack = new Stack<>();

        stack.push(currNode);
        while (!stack.isEmpty()) {

            currNode = stack.pop();

            System.out.println(currNode.val);

            if (currNode.right != null) {
                stack.push(currNode.right);
            }
            if (currNode.left != null) {
                stack.push(currNode.left);
            }
        }
    }

    public void revisionInorderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        while (!stack.isEmpty() || currNode != null) {
            if (currNode != null) {
                stack.push(currNode);
                currNode = currNode.left;
            } else {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                currNode = node.right;

            }
        }
    }

    //https://www.geeksforgeeks.org/iterative-postorder-traversal/?ref=lbp
    public List<TreeNode> revisionPostorderWithStack(TreeNode root) {
        LinkedList<TreeNode> out = new LinkedList<>();
        if (root == null) {
            return out;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currNode = root;

        stack.push(currNode);
        while (!stack.isEmpty()) {
            currNode = stack.pop();
            out.addFirst(currNode);

            if (currNode.left != null) {
                stack.push(currNode.left);
            }
            if (currNode.right != null) {
                stack.push(currNode.right);
            }
        }

        return out;
    }

    //https://leetcode.com/problems/invert-binary-tree/
    public TreeNode revisionInvertTree(TreeNode root) {
        if (root != null) {
            revisionInvertTree(root.left);
            revisionInvertTree(root.right);
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        return root;
    }

    /*
     * LeetCode 113. Path Sum II
     * https://leetcode.com/problems/path-sum-ii/
     *
     * */
    public boolean revisionHasSumStackInorder(TreeNode root, int sum) {
        Stack<Integer> pathSums = new Stack<>();
        int currSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode next = root;

        while (!stack.isEmpty() || next != null) {
            if (next != null) {
                stack.push(next);
                currSum += next.val;
                pathSums.push(currSum);
                next = next.left;
            } else {
                TreeNode node = stack.pop();
                if (node.left == null && node.right == null && currSum == sum) {
                    return true;
                }
                currSum -= node.val;
                System.out.println(node.val);
                next = node.right;
            }
        }
        return false;
    }

    public boolean revisionHasSumRecursive(TreeNode root, int sum) {
        int currSum = 0;
        return revisionHasSumRecursiveHelper(root, sum, currSum);
    }

    private boolean revisionHasSumRecursiveHelper(TreeNode root, int sum, int currSum) {
        if (root == null) {
            return false;
        }
        boolean result = false;
        currSum += root.val;
        if (root.left == null && root.right == null && currSum == sum) {
            return true;
        }
        return revisionHasSumRecursiveHelper(root.left, sum, currSum) || revisionHasSumRecursiveHelper(root.right, sum, currSum);
    }

    public boolean revisionIsBST(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        if (lower != null && node.val < lower) {
            return false;
        }
        if (upper != null && node.val > upper) {
            return false;
        }
        return revisionIsBST(node.left, lower, node.val) && revisionIsBST(node.right, node.val, upper);
    }

    /*
     * LeetCode 113. Path Sum II
     * https://leetcode.com/problems/path-sum-ii/
     *
     * */
    public List<List<Integer>> revisionPathSum(TreeNode root, int sum) {
        List<List<Integer>> paths = new ArrayList<>();
        int currSum = 0;
        List<Integer> tempPath = new ArrayList<>();
        revisionPathSumUtil(root, sum, paths, currSum, tempPath);
        return paths;
    }

    private void /*List<List<Integer>>*/ revisionPathSumUtil(TreeNode node, int sum, List<List<Integer>> paths, int currSum, List<Integer> tempPath) {
        if (node == null) {
            return;
        }

        currSum += node.val;
        tempPath.add(node.val);
        if (node.left == null && node.right == null && sum == currSum) {
            paths.add(new ArrayList<>(tempPath));
        }

        revisionPathSumUtil(node.left, sum, paths, currSum, tempPath);
        revisionPathSumUtil(node.right, sum, paths, currSum, tempPath);
        tempPath.remove(tempPath.size() - 1);
    }


    //---------------------------------------------------------------------------------------------------------------------------------------------------------

    //---------------------------------------------------------Helpers---------------------------------------------------------

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

    public TreeNode initTree3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
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
            left = right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
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
