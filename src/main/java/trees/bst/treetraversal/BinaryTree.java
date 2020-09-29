package trees.bst.treetraversal;

import trees.bst.model.TreeNode;

//https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/
//https://towardsdatascience.com/4-types-of-tree-traversal-algorithms-d56328450846
public class BinaryTree {
    private TreeNode root;

    public BinaryTree(TreeNode root) {
        this.root = root;
    }

    /*
    * One of the important property of inorder traversal is that it prints the nodes in sorted order if given binary
    *  tree is a binary search tree.
    * */
    public void inOrderTraversal(TreeNode treeNode) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.getLeft());
            System.out.println(treeNode.getVal());
            inOrderTraversal(treeNode.getRight());
        }
    }

    public void preOrderTraversal(TreeNode treeNode) {
        if(treeNode != null) {
            System.out.println(treeNode.getVal());
            preOrderTraversal(treeNode.getLeft());
            preOrderTraversal(treeNode.getRight());
        }
    }

    public void postOrderTraversal(TreeNode treeNode) {
        if(treeNode != null) {
            postOrderTraversal(treeNode.getLeft());
            postOrderTraversal(treeNode.getRight());
            System.out.println(treeNode.getVal());
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
}
