package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

public class DiameterExclRoot {

    public int diameterOfBinaryTree(TreeNode root) {
        getDiameter(root);
        return maximumDiameter - 1;
    }

    int maximumDiameter = 0;

    private int getDiameter(TreeNode node) {
        if(node == null) {
            return 0;
        }

        int leftPath = getDiameter(node.left);
        int rightPath = getDiameter(node.right);

        int currentDiameter = leftPath + rightPath + 1;
        int longestPath = leftPath > rightPath ? leftPath + 1: rightPath + 1;

        if(currentDiameter > maximumDiameter) {
            maximumDiameter = currentDiameter;
        }

        return longestPath;

    }

}
