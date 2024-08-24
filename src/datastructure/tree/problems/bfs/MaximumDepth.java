package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

public class MaximumDepth {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return calculateLevel(root, 1);
    }

    private int calculateLevel(TreeNode node, int level) {
        if(node == null) {
            return -1;
        }

        int leftLevel = calculateLevel(node.left, level + 1);
        int rightLevel = calculateLevel(node.right, level + 1);

        if(leftLevel == -1 && rightLevel == -1) {
            return level;
        }

        return Math.max(leftLevel, rightLevel);
    }
}
