package trees.bst.treetraversal;

import trees.bst.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Iterative traversing binary tree with stack
 * */
public class BinaryTreeStack {
    private TreeNode root;

    public BinaryTreeStack(TreeNode root) {
        this.root = root;
    }

    private void visit(List<Integer> result, TreeNode node) {
        System.out.println(node.getVal());
        result.add(node.getVal());
    }

    //https://javarevisited.blogspot.com/2016/08/inorder-traversal-of-binary-tree-in-java-recursion-iteration-example.html
    //https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
    //https://www.techiedelight.com/inorder-tree-traversal-iterative-recursive/
    public List<Integer> inOrderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = treeNode;

        while (!stack.isEmpty() || current != null) {
            if (current != null) {
                stack.push(current);
                current = current.getLeft();
            } else {
                TreeNode node = stack.pop();
                visit(result, node);
                current = node.getRight();
            }
        }
        return result;
    }

    //https://www.geeksforgeeks.org/iterative-preorder-traversal/   <------ !!! fajnie opisane
    //https://javarevisited.blogspot.com/2016/07/binary-tree-preorder-traversal-in-java-using-recursion-iteration-example.html
    public List<Integer> preOrderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = treeNode;
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            visit(result, current);
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
        }
        return result;
    }

    //https://www.geeksforgeeks.org/iterative-postorder-traversal/?ref=lbp <----- !!!! bradzo fajnie opisane i rozwiazane
    //https://www.techiedelight.com/postorder-tree-traversal-iterative-recursive/
    public List<Integer> postOrderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        if (treeNode == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> out = new Stack<>();

        TreeNode current = treeNode;
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            out.push(current);
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }
        while (!out.isEmpty()) {
            visit(result, out.pop());
        }
        return result;
    }

    //TODO !!!! Najlepsze rozwiazanie z LinkedLista zamiast stosu i addFirst();
    //https://leetcode.com/problems/binary-tree-postorder-traversal/solution/
    public List<Integer> postOrderTraversalTheBest(TreeNode treeNode) {
        LinkedList<Integer> out = new LinkedList<>();
        if (treeNode == null) {
            return out;
        }
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = treeNode;
        stack.push(current);

        while (!stack.isEmpty()) {
            current = stack.pop();
            out.addFirst(current.getVal());
            if (current.getLeft() != null) {
                stack.push(current.getLeft());
            }
            if (current.getRight() != null) {
                stack.push(current.getRight());
            }
        }
        return out;
    }

    //TODO przyklad blednego rozwiazania
    //https://www.techiedelight.com/postorder-tree-traversal-iterative-recursive/ <---- niedopre rozwiazanie poniewaz niszczy drzewo podczas odwiedzin: current.setRight(null) oraz  current.setLeft(null);
/*    public List<Integer> postOrderTraversal(TreeNode treeNode) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(treeNode);

        while (!stack.isEmpty()) {
            TreeNode current = stack.peek();
            if (current.isLeaf()) {
                TreeNode node = stack.pop();
                visit(result, node);
            } else {
                if (current.getRight() != null) {
                    stack.push(current.getRight());
                    current.setRight(null);
                }
                if (current.getLeft() != null) {
                    stack.push(current.getLeft());
                    current.setLeft(null);
                }
            }
        }
        return result;
    }*/

    public TreeNode getRoot() {
        return root;
    }
}
