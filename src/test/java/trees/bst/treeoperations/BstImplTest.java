package trees.bst.treeoperations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trees.bst.treetraversal.BinaryTreeStack;

import static org.junit.jupiter.api.Assertions.*;

class BstImplTest {//TODO correct tests
    private BstImpl bst;

    @BeforeEach
    void setUp() {
        bst = new BstImpl();
    }

    @Test
    void search() {
    }

    @Test
    void insert() {
    }

    @Test
    void isValidBST() {
        BstImpl.TreeNode root = bst.initTree2();
        boolean actualResult = BstImpl.isBST(root, null,null);
        assertTrue(actualResult);
    }

    @Test
    void rangeSumBST() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.initTree2();
        int actualResult = bst.rangeSumBST(root, 11,90);
        int expectedResult = 244;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void convertSortedArrayToBST() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{-10,-3,0,5,9});
        int expectedResult = 244;
/*        assertEquals(expectedResult, actualResult);*/
    }


    @Test
    void invertTreeTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1,2,3,4,6,7,9});
        BstImpl.TreeNode invertedTree = bst.invertTree(root);
        int expectedResult = 244;
        /*        assertEquals(expectedResult, actualResult);*/
    }

    //---------------------------------------------hasPathSumTest-------------------------------------------------

    @Test
    void hasPathSumTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1,2,3,4,6,7,9});
        boolean actualResult = bst.hasPathSumStack(root,9);//hasPathSum(root,9);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest2() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1,2,3,4,6,7,9});
        boolean actualResult = bst.hasPathSumStack(root,17);//bst.hasPathSum(root,17);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest3() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1,2,3,4,6,7,9});
        boolean actualResult = bst.hasPathSumStack(root,-21);//bst.hasPathSum(root,-21);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest4() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{});
        boolean actualResult = bst.hasPathSumStack(root,0);//bst.hasPathSum(root,0);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }
    //---------------------------------------------------------------------------------------------------------------
    @Test
    void delete() {
    }

}