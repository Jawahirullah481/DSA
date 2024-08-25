package datastructure.tree.problems;

public class MergeTwoBinaryTree617 {
    public TreeNode mergeTree(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) {
            return null;
        }

        if(node1 == null) {
            return node2;
        }

        if(node2 == null) {
            return node1;
        }

        node1.val = node1.val + node2.val;
        node1.left = mergeTree(node1.left, node2.left);
        node1.right = mergeTree(node1.right, node2.right);

        return node1;
    }
}
