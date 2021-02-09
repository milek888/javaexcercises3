package trees.bst.revision;


import trees.bst.model.TreeNode;

/*
 * 226. Invert Binary Tree -> It doesn't have to be BST. It's binary tree
 * https://leetcode.com/problems/invert-binary-tree/
 * Odwracamy najpierw dla wiezcholkowlewego i prawego po te dla rodzica
 * jak wynika z rysunku bo jakbysmy najpierw dla rodzica odwrocili to bysmy
 * razy dla lewego zrobili bo prawy by sie stal lewym dlatego odwracamy w porzadku
 * postorder
 * */
public class InvertBinaryTreeRevision {
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tempNode = root.right;
        root.right = root.left;
        root.left = tempNode;
        return root;
    }


}
