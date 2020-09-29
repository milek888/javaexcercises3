package trees.bst.treeoperations;

public interface Bst {
    BstImpl.TreeNode search(BstImpl.TreeNode node, int val);

    void insert(int val);

    void delete(int val);
}
