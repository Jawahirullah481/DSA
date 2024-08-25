package datastructure.tree.problems;

public class MinimumDepth111 {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return depth(root, 0) + 1;
    }

    private int depth(TreeNode node, int level) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }

        // If both are null, it is the leaf node. Just return its level
        if(node.left == null && node.right == null) {
            return level;
        }

        return Math.min(depth(node.left, level + 1), depth(node.right, level + 1));

    }
}
