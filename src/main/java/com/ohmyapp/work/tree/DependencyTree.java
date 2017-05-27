package com.ohmyapp.work.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created on 3/26/2017.
 */
public class DependencyTree {
    private List<Tree> treeStack = new ArrayList<>();
    private Set<Tree> projectSet = new HashSet<>();

    public List<Tree> build(Set<Tree> projects) {
        while (true) {
            for (Tree tree : projects) {
                dfs(tree);
            }
            Set<Tree> remainingProjects = new HashSet<>();
            for (Tree tree : projectSet) {
                if (!"completed".equals(tree.getStatus())) {
                    tree.setStatus("");
                    remainingProjects.add(tree);
                }
            }
            if (remainingProjects.isEmpty()) {
                break;
            }
            projectSet.clear();
            projects.clear();
            projects.addAll(remainingProjects);
        }
        return treeStack;
    }

    private void dfs(Tree tree) {
        if (tree.getStatus().isEmpty()) {
            tree.setStatus("visited");
            projectSet.add(tree);
        } else {
            return;
        }
        Set<Tree> branches = tree.getBranches();
        if (branches.isEmpty()) {
            // this is a leaf
            treeStack.add(tree);
            System.out.println(tree.getId() +" is a leaf");
            tree.setStatus("completed");
            return;
        }
        Set<Tree> newBranches = new HashSet<>(branches);
        for (Tree branch : newBranches) {
            dfs(branch);
            if ("completed".equals(branch.getStatus())) {
                branches.remove(branch);
            }
        }
    }
}
