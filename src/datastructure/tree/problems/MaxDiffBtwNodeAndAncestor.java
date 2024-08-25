package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

public class MaxDiffBtwNodeAndAncestor {
    int maxDiff = Integer.MIN_VALUE;
    public int maxAncestorDiff(TreeNode root) {
        maxDifference(root, root.val, root.val);
        return maxDiff;
    }

    private int maxDifference(TreeNode node, int greatestAncestor, int smallestAncestor) {
        if(node == null) {
            return Integer.MAX_VALUE;
        }

        int diff1 = Math.abs(greatestAncestor - node.val);
        int diff2 = Math.abs(smallestAncestor - node.val);
        maxDiff = Math.max(diff1, maxDiff);
        maxDiff = Math.max(diff2, maxDiff);

        if(node.val > greatestAncestor) {
            maxDifference(node.left, node.val, smallestAncestor);
            maxDifference(node.right, node.val, smallestAncestor);
        } else if(node.val < smallestAncestor) {
            maxDifference(node.left, greatestAncestor, node.val);
            maxDifference(node.right, greatestAncestor, node.val);
        } else {
            maxDifference(node.left, greatestAncestor, smallestAncestor);
            maxDifference(node.right, greatestAncestor, smallestAncestor);
        }


        return 0;
    }
}
