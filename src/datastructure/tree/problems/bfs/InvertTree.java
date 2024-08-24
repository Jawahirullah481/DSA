package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

public class InvertTree {
    public TreeNode invert(TreeNode node) {
        if(node == null) {
            return null;
        }

        TreeNode leftNode = invert(node.left);
        TreeNode rightNode = invert(node.right);



        node.left = rightNode;
        node.right = leftNode;


        return node;
    }
}
