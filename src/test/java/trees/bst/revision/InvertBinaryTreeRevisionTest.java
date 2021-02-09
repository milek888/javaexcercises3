package trees.bst.revision;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import trees.bst.model.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeRevisionTest {

    @Test
    void invertTree() {
        TreeNode root = SortedArrayToBST.convertSortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        TreeNode rootInverted = InvertBinaryTreeRevision.invertTree(root);
        List<Integer> actualResult = PreInPostOrderStackTraversalRevision.inOrderTraversal(rootInverted);//jak tu damy inOrderTraversal(root)
        //tez dobrze wyjdzie bo drzewo wejsciowe zostało zmienione cale.
        List<Integer> expectedResult = List.of(9,7,6,4,3,2,1);
        Assertions.assertIterableEquals(expectedResult, actualResult);
    }
}