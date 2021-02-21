package trees.bst.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trees.bst.model.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class PreInPostOrderTraversalRevision2Test {

    @Test
    void runPreOrder() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        int actualResult = PreInPostOrderTraversalRevision2.runPreOrder(root, 1);
        int expectedResult = 9;
        Assertions.assertEquals(expectedResult, actualResult);
    }

}