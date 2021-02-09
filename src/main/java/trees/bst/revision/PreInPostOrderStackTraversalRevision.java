package trees.bst.revision;

import trees.bst.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreInPostOrderStackTraversalRevision {

    public static List<Integer> postOrderTraversal(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        LinkedList<Integer> result = new LinkedList<>();
        if (treeNode == null) {
            return result;
        }

        TreeNode curr = treeNode;
        nodeStack.push(curr);
        while (!nodeStack.isEmpty()) {
            curr = nodeStack.pop();
            result.addFirst(curr.val);

            if (curr.left != null) {
                nodeStack.push(curr.left);
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
        }

        return result;
    }


    public static List<Integer> preOrderTraversal(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (treeNode == null) {
            return result;
        }

        TreeNode curr = treeNode;
        nodeStack.push(curr);
        while (!nodeStack.isEmpty()) {
            curr = nodeStack.pop();
            System.out.println(curr.val);
            result.add(curr.val);

            if (curr.right != null) {
                nodeStack.push(curr.right);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
            }
        }

        return result;
    }

    public static List<Integer> inOrderTraversal(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (treeNode == null) {
            return result;
        }

        TreeNode curr = treeNode;
        while (!nodeStack.isEmpty() || curr != null) {
            if (curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            } else {
                curr = nodeStack.pop();
                System.out.println(curr.val);
                result.add(curr.val);
                curr = curr.right;
            }
        }
        return result;
    }
}

