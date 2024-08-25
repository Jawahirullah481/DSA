package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

public class ConvertBSTToLL {
    public void flatten(TreeNode root) {
        TreeNode node = root;

        while(node != null) {
            TreeNode backup = null;

            if(node.left != null) {
                backup = node.right;
                node.right = node.left;
                node.left = null;
                TreeNode rightMost = getRightMost(node);
                rightMost.right = backup;
            }

            node = node.right;
        }
    }

    private TreeNode getRightMost(TreeNode node) {

        while(node.right != null) {
            node = node.right;
        }

        return node;
    }
}
