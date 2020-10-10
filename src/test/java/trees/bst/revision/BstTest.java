package trees.bst.revision;

import org.junit.jupiter.api.Test;
import trees.bst.treeoperations.BstImpl;

import static org.junit.jupiter.api.Assertions.*;

class BstTest {//TODO tests

    @Test
    void pathSum3Test() {
       Bst.Node root = Bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        int counter = Bst.pathSum(root, 17);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void pathSum3Test2() {
        Bst.Node root = Bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        int counter = Bst.pathSum(root, 51);
        System.out.println("---------------------------------------------------------------------");
    }
}