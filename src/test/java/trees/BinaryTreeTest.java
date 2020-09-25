package trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeTest {//TODO refactor tests

    private BinaryTree binaryTree;

    @BeforeEach
    void setUp() {
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(3,treeNode5, treeNode6);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, treeNode4);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode7 = new TreeNode(7,treeNode8, treeNode9);
        TreeNode treeNode1 = new TreeNode(1,treeNode2, treeNode7);
        binaryTree = new BinaryTree(treeNode1);
    }

    @Test
    void inOrderTraversal() {
        TreeNode root = binaryTree.getRoot();
        binaryTree.inOrderTraversal(root);
    }

    @Test
    void preOrderTraversal() {
        TreeNode root = binaryTree.getRoot();
        binaryTree.preOrderTraversal(root);

    }

    @Test
    void postOrderTraversal() {
        TreeNode root = binaryTree.getRoot();
        binaryTree.postOrderTraversal(root);

    }
}