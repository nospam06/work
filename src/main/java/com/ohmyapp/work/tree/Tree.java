package com.ohmyapp.work.tree;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 3/26/2017.
 */
@Data
public class Tree {
    private int id;
    private Set<Tree> branches = new HashSet<>();
    private String status = "";

    public void addBranch(Tree branch) {
        branches.add(branch);
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object other) {
        return super.equals(other) && hashCode() == other.hashCode();
    }
}
