package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return sumHelper(root, targetSum, 0);
    }

    private boolean sumHelper(TreeNode node, int targetSum, int pathSum) {
        if (node == null) {
            return false;
        }

        pathSum += node.val;

        if(pathSum == targetSum && node.left == null && node.right == null) {
            return true;
        }

        return sumHelper(node.left, targetSum, pathSum) || sumHelper(node.right, targetSum, pathSum);
    }
}
