package trees.bst.treeoperations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BstImplTest {//TODO refactor all tests
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
        boolean actualResult = BstImpl.isBST(root, null, null);
        assertTrue(actualResult);
    }

    @Test
    void rangeSumBST() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.initTree2();
        int actualResult = bst.rangeSumBST(root, 11, 90);
        int expectedResult = 244;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void convertSortedArrayToBST() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        int expectedResult = 244;
        /*        assertEquals(expectedResult, actualResult);*/
    }


    @Test
    void invertTreeTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        BstImpl.TreeNode invertedTree = bst.invertTree(root);
        int expectedResult = 244;
        /*        assertEquals(expectedResult, actualResult);*/
    }

    //---------------------------------------------hasPathSumTest-------------------------------------------------

    @Test
    void hasPathSumTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        boolean actualResult = bst.hasPathSumStack(root, 9);//hasPathSum(root,9);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest2() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        boolean actualResult = bst.hasPathSumStack(root, 17);//bst.hasPathSum(root,17);
        boolean expectedResult = true;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest3() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        boolean actualResult = bst.hasPathSumStack(root, -21);//bst.hasPathSum(root,-21);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void hasPathSumTest4() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{});
        boolean actualResult = bst.hasPathSumStack(root, 0);//bst.hasPathSum(root,0);
        boolean expectedResult = false;
        assertEquals(expectedResult, actualResult);
    }
    //--------------------------------------------------LeetCode 113. Path Sum II-------------------------------------------------------------

    @Test
    void getPathsTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        ArrayList<ArrayList<Integer>> actualPaths = bst.pathSum(root, 9);
        List<List<Integer>> expectedPaths = null;
        /*        assertEquals(expectedResult, actualResult);*/
    }

    @Test
    void getPathsTest2() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 6, 7, 9});
        ArrayList<ArrayList<Integer>> actualPaths = bst.pathSum(root, 17);
        List<List<Integer>> expectedPaths = null;
        /*       assertEquals(expectedResult, actualResult);*/
    }

    @Test
    void getPathsTest4() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{});
        ArrayList<ArrayList<Integer>> actualPaths = bst.pathSum(root, 17);
        List<List<Integer>> expectedPaths = null;
        /*        assertEquals(expectedResult, actualResult);*/
    }

    //---------------------------------------------------------------------------------------------------------------

    @Test
    void pathSum3Test() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        int counter = bst.pathSum3(root, 17);
        System.out.println("---------------------------------------------------------------------");

    }

    @Test
    void treeFromArrayTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.anyArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        bst.revisionPreorderRecursive(root);
        System.out.println("---------------------------------------------------------------------");
    }

    //------------------------------------------------------Powtorka---------------------------------------------------------

    @Test
    void revisionPreorderRecursiveTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        bst.revisionPreorderRecursive(root);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionInorderRecursiveTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        /*        BstImpl.TreeNode root = bst.initTree3();*/
        bst.revisionInorderRecursive(root);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionPostorderRecursiveTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        /*        BstImpl.TreeNode root = bst.initTree3();*/
        bst.revisionPostorderRecursive(root);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionPreorderWithStackTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        /*        BstImpl.TreeNode root = bst.initTree3();*/
        bst.revisionPreorderWithStack(root);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionInorderWithStackTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        /*        BstImpl.TreeNode root = bst.initTree3();*/
        bst.revisionInorderWithStack(root);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionPostorderWithStackTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        List<BstImpl.TreeNode> actualResult = bst.revisionPostorderWithStack(root);
        actualResult.forEach(System.out::println);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionInvertTreeTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        BstImpl.TreeNode actualResulst = bst.revisionInvertTree(root);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionHasSumHelperTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        boolean actualResult = bst.revisionHasSumStackInorder(root, 17);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionHasSumRecursiveTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        boolean actualResult = bst.revisionHasSumRecursive(root, 47);
        System.out.println("---------------------------------------------------------------------");
    }


    @Test
    void revisionIsBSTTest() {//TODO test with tree which is not BST
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        boolean actualResult = bst.revisionIsBST(root, null, null);
        System.out.println("---------------------------------------------------------------------");
    }

    @Test
    void revisionPathSumTest() {
        BstImpl bst = new BstImpl();
        BstImpl.TreeNode root = bst.sortedArrayToBST(new int[]{1, 2, 1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 17});
        List<List<Integer>> actualResult = bst.revisionPathSum(root,15);
        System.out.println("---------------------------------------------------------------------");
    }
}