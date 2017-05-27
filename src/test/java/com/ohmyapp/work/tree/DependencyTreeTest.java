package com.ohmyapp.work.tree;

import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 3/26/2017.
 */
public class DependencyTreeTest {
    @Test
    public void build() throws Exception {
        Set<Tree> treeList1 = new HashSet<>();
        Tree tree1 = new Tree();
        tree1.setId(1);

        Tree tree5 = new Tree();
        tree5.setId(5);
        Tree tree15 = new Tree();
        tree15.setId(15);

        Tree tree25 = new Tree();
        tree25.setId(25);
        Tree tree50 = new Tree();
        tree50.setId(50);
        Tree tree35 = new Tree();
        tree35.setId(35);
        Tree tree45 = new Tree();
        tree45.setId(45);

        tree25.addBranch(tree50);
        tree1.addBranch(tree5);
        tree1.addBranch(tree15);
        tree1.addBranch(tree50);
        tree15.addBranch(tree35);
        tree35.addBranch(tree25);
        tree45.addBranch(tree35);
        tree45.addBranch(tree1);

        treeList1.add(tree5);
        treeList1.add(tree15);
        treeList1.add(tree25);
        treeList1.add(tree35);
        treeList1.add(tree50);
        treeList1.add(tree1);
        treeList1.add(tree45);

        List<Tree> treeList = new DependencyTree().build(treeList1);
        for (Tree tree : treeList) {
            System.out.println(tree.getId());
        }
    }
}