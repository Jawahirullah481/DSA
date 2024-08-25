package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

public class CheckNodesAreCousins {
    public boolean isCousins(TreeNode root, int x, int y) {
        TreeNode xNode = findNode(root, x);
        TreeNode yNode = findNode(root, y);

        int xLevel = level(root, xNode, 0);
        int yLevel = level(root, yNode, 0);

        return (xLevel == yLevel && (!isSibling(root, xNode, yNode)));
    }

    private TreeNode findNode(TreeNode node, int val) {
        if(node == null || node.val == val) {
            return node;
        }

        TreeNode leftNode = findNode(node.left, val);
        if(leftNode != null) {
            return leftNode;
        }

        TreeNode rightNode = findNode(node.right, val);

        return rightNode;
    }

    private int level(TreeNode node, TreeNode searchNode, int level) {
        if(node == null) {
            return -1;
        }

        if(node == searchNode) {
            return level;
        }

        int leftLevel = level(node.left, searchNode, level + 1);

        if(leftLevel != -1) {
            return leftLevel;
        }

        int rightLevel = level(node.right, searchNode, level + 1);
        return rightLevel;
    }

    private boolean isSibling(TreeNode node, TreeNode xNode, TreeNode yNode) {
        if(node == null) {
            return false;
        }

        if((node.left == xNode && node.right == yNode) || (node.right == xNode && node.left == yNode)) {
            return true;
        }

        return isSibling(node.left, xNode, yNode) || isSibling(node.right, xNode, yNode);
    }
}
