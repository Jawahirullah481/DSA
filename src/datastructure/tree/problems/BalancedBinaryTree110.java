package datastructure.tree.problems;

public class BalancedBinaryTree110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right) && Math.abs(height(root.left) - height(root.right)) <= 1;
    }

    private int height(TreeNode node) {
        if(node == null) {
            return -1;
        }

        return Math.max(height(node.left), height(node.right)) + 1;
    }
}
