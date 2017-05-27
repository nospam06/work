package com.ohmyapp.work.tree;

import com.ohmyapp.work.tree.service.BinaryTreeService;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * Created on 3/26/2017.
 */
public class BinaryTreeTest {
    private static final Logger LOGGER = Logger.getLogger(BinaryTreeTest.class.getName());

    @Test
    public void fromArray() throws Exception {
        int[] test1 = new int[]{1};
        int[] test2 = new int[]{1, 2};
        int[] test3 = new int[]{1, 2, 3};
        int[] test4 = new int[]{1, 2, 3, 4};
        int[] test5 = new int[]{1, 2, 3, 4, 5};
        int[] test6 = new int[]{1, 2, 3, 4, 5, 6};
        int[] test7 = new int[]{1, 2, 3, 4, 5, 6, 7};
        BinaryTree result1 = BinaryTreeService.fromArray(test1);

        BinaryTree result2 = BinaryTreeService.fromArray(test2);

        BinaryTree result3 = BinaryTreeService.fromArray(test3);

        BinaryTree result4 = BinaryTreeService.fromArray(test4);
        BinaryTree result5 = BinaryTreeService.fromArray(test5);
        BinaryTree result6 = BinaryTreeService.fromArray(test6);
        BinaryTree result7 = BinaryTreeService.fromArray(test7);
        BinaryTreeService.checkBalance(result7);
        LOGGER.info("End");
    }

    @Test
    public void toList() {
        BinaryTree root = testData();

        BinaryTree node = new BinaryTreeService().toDoubleList(root);
    }

    @Test
    public void calDepth() {
        BinaryTree root = testData();

        int depth = BinaryTreeService.checkBalance(root);
    }

    private BinaryTree testData() {
        BinaryTree root = new BinaryTree();
        root.setId(10);
        BinaryTree node6 = new BinaryTree();
        node6.setId(6);
        BinaryTree node20 = new BinaryTree();
        node20.setId(20);
        root.setLeft(node6);
        root.setRight(node20);
        //
        BinaryTree node3 = new BinaryTree();
        node3.setId(3);
        BinaryTree node9 = new BinaryTree();
        node9.setId(9);
        node6.setLeft(node3);
        node6.setRight(node9);
        //
        BinaryTree node1 = new BinaryTree();
        node1.setId(1);
        node3.setLeft(node1);
        //
        BinaryTree node15 = new BinaryTree();
        node15.setId(15);
        BinaryTree node25 = new BinaryTree();
        node25.setId(25);
        node20.setLeft(node15);
        node20.setRight(node25);
        //
        BinaryTree node13 = new BinaryTree();
        node13.setId(13);
        node15.setLeft(node13);
        //
        BinaryTree node35 = new BinaryTree();
        node35.setId(35);
        node25.setRight(node35);
        //
        BinaryTree node55 = new BinaryTree();
        node55.setId(55);
        node35.setRight(node55);
        return root;
    }
}