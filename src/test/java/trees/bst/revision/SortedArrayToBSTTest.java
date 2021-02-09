package trees.bst.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trees.bst.model.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayToBSTTest {

    @Test
    void convertSortedArrayToBST() {
        List<Integer> expectedResult = List.of(1, 2, 3, 4, 6, 7, 9);
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        List<Integer> actualResult = PreInPostOrderStackTraversalRevision.inOrderTraversal(root);//dobry pomysl zeby to w ten sposob testowac
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }
}