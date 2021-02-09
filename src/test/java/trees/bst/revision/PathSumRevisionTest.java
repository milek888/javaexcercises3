package trees.bst.revision;

import org.junit.jupiter.api.Test;
import trees.bst.model.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class PathSumRevisionTest {

    @Test
    void hasPathSumTest() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        boolean actualResult = PathSumRevision.hasPathSum(root, 9);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest2() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        boolean actualResult = PathSumRevision.hasPathSum(root, 17);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest3() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        boolean actualResult = PathSumRevision.hasPathSum(root, -21);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest4() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{});
        boolean actualResult = PathSumRevision.hasPathSum(root, 0);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }
}