package trees.bst.revision;

import trees.bst.model.TreeNode;


import java.util.concurrent.atomic.AtomicInteger;

/*
* Zadanie z CGI Deutche rozmowa posumowac wezly na danym poziomie drezwa
* */
public class PreInPostOrderTraversalRevision2 {

    public static int runPreOrder(TreeNode node, int targetLevel) {
        AtomicInteger sum = new AtomicInteger(0);
        int level = 0;
        preOrder(node, level, targetLevel, sum);
        return sum.get();
    }

    private static void preOrder(TreeNode node, int level, int targetLevel, AtomicInteger sum) {
        if (node != null) {
            level++;
            if (level == targetLevel) {
                sum.addAndGet(node.val);
            }
            System.out.println(node.val);
            preOrder(node.left, level, targetLevel, sum);
            preOrder(node.right, level, targetLevel, sum);
        }
    }

}
