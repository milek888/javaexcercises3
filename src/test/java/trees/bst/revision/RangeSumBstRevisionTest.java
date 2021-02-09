package trees.bst.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trees.bst.model.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class RangeSumBstRevisionTest {

    @Test
    void rangeSumBST() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        RangeSumBstRevision rangeSumBstRevision = new RangeSumBstRevision();
        int actualSum = rangeSumBstRevision.rangeSumBST(root, 3, 6);
        int expectedSum = 13;
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    void rangeSumBST2() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        RangeSumBstRevision rangeSumBstRevision = new RangeSumBstRevision();
        int actualSum = rangeSumBstRevision.rangeSumBST(root, 1, 6);
        int expectedSum = 16;
        Assertions.assertEquals(expectedSum, actualSum);
    }

    @Test
    void rangeSumBST3() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        RangeSumBstRevision rangeSumBstRevision = new RangeSumBstRevision();
        int actualSum = rangeSumBstRevision.rangeSumBST(root, 9, 9);
        int expectedSum = 9;
        Assertions.assertEquals(expectedSum, actualSum);
    }
}