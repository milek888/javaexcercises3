package trees.bst.treetraversal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trees.bst.model.TreeNode;
import trees.bst.treetraversal.BinaryTreeStack;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class
BinaryTreeStackTest {//TODO refactor tests

    private BinaryTreeStack binaryTreeStack;

    @BeforeEach
    void setUp() {
        this.binaryTreeStack = initTree1();
    }

    @Test
    void inOrderTraversal() {
        TreeNode root = binaryTreeStack.getRoot();
        List<Integer> actualTraversal = binaryTreeStack.inOrderTraversal(root);
        List<Integer> expectedTraversal = List.of(5, 3, 6, 2, 4, 1, 8, 7, 9);
        assertIterableEquals(actualTraversal, expectedTraversal);
    }

    @Test
    void preOrderTraversal() {
        TreeNode root = binaryTreeStack.getRoot();
        List<Integer> actualTraversal = binaryTreeStack.preOrderTraversal(root);
        List<Integer> expectedTraversal = List.of(1, 2, 3, 5, 6, 4, 7, 8, 9);
        assertIterableEquals(actualTraversal, expectedTraversal);
    }

    @Test
    void postOrderTraversal() {
        TreeNode root = binaryTreeStack.getRoot();
        List<Integer> actualTraversal = binaryTreeStack.postOrderTraversal(root);
        List<Integer> expectedTraversal = List.of(5, 6, 3, 4, 2, 8, 9, 7, 1);
        assertIterableEquals(actualTraversal, expectedTraversal);
    }

    @Test
    void postOrderTraversalTheBest() {
        TreeNode root = binaryTreeStack.getRoot();
        List<Integer> actualTraversal = binaryTreeStack.postOrderTraversalTheBest(root);
        List<Integer> expectedTraversal = List.of(5, 6, 3, 4, 2, 8, 9, 7, 1);
        assertIterableEquals(actualTraversal, expectedTraversal);
    }

    private BinaryTreeStack initTree1() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3, treeNode5, treeNode6);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, treeNode4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(7, treeNode8, treeNode9);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode7);
        return new BinaryTreeStack(treeNode1);
    }

    private BinaryTreeStack initTree2() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode3 = new TreeNode(3, treeNode6, treeNode7);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(1, treeNode2, treeNode3);
        return new BinaryTreeStack(treeNode1);
    }
}