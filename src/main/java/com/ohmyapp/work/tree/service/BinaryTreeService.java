package com.ohmyapp.work.tree.service;

import com.ohmyapp.work.tree.BinaryTree;

/**
 * Created on 3/26/2017.
 */
public class BinaryTreeService {
    private BinaryTree nodeStack;

    public static int checkBalance(BinaryTree input) {
        return calculateDepth(input);
    }

    public BinaryTree toDoubleList(BinaryTree input) {
        drillDown(input);
        return setRight(nodeStack);
    }

    public static BinaryTree fromArray(int[] input) {
        BinaryTree root = new BinaryTree();
        cutInHalf(input, 0, input.length - 1, root);
        return root;
    }

    private void drillDown(BinaryTree input) {
        System.out.println("input = " + input.getId());
        if (input.getLeft() != null) {
            drillDown(input.getLeft());
        }
        System.out.println("adding to list = " + input.getId());
        input.setLeft(nodeStack);
        nodeStack = input;
        if (input.getRight() != null) {
            drillDown(input.getRight());
        }
    }

    private static BinaryTree setRight(BinaryTree nodeStack) {
        BinaryTree prevNode = nodeStack;
        BinaryTree node = nodeStack;
        while (node.getLeft() != null) {
            node = node.getLeft();
            System.out.println("Prev=" + prevNode.getId() + " current=" + node.getId());
            node.setRight(prevNode);
            prevNode = node;
        }
        return node;
    }

    private static void cutInHalf(int[] input, int start, int end, BinaryTree branch) {
        int half = (end + 1 + start) / 2;
        branch.setId(input[half]);
        // left
        if (half <= start) {
            return;
        }
        BinaryTree left = new BinaryTree();
        branch.setLeft(left);
        cutInHalf(input, start, half - 1, left);
        // right
        if (half + 1 > end) {
            return;
        }
        BinaryTree right = new BinaryTree();
        branch.setRight(right);
        cutInHalf(input, half + 1, end, right);
    }

    private static int calculateDepth(BinaryTree input) {
        int left = 0;
        int right = 0;
        if (input.getLeft() != null) {
            left = calculateDepth(input.getLeft());
            ++left;
        }
        if (input.getRight() != null) {
            right = calculateDepth(input.getRight());
            ++right;
        }
        int myDepth = Math.max(left, right);
        System.out.println(input.getId() + " left = " + left + " right = " + right);
        if (Math.abs(left - right) > 1) {
            System.err.println("Tree is not balance at " + input.getId());
        }
        return myDepth;
    }
}
