package trees.bst.revision;

import trees.bst.model.TreeNode;

public class PreInPostOrderTraversalRevision {

    public void preOrderTraversal(TreeNode treeNode) {
        TreeNode curr = treeNode;
        if (curr != null) {
            inOrderTraversal(curr.left);
            System.out.println(curr.val);
            inOrderTraversal(curr.right);
        }
    }

    public void inOrderTraversal(TreeNode treeNode) {
        TreeNode curr = treeNode;
        if (curr != null) {
            System.out.println(curr.val);
            inOrderTraversal(curr.left);
            inOrderTraversal(curr.right);
        }
    }

    public void postOrderTraversal(TreeNode treeNode) {
        TreeNode curr = treeNode;
        if (curr != null) {
            System.out.println(curr.val);
            inOrderTraversal(curr.left);
            inOrderTraversal(curr.right);
        }
    }
}
