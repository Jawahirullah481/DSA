package datastructure.tree.problems;

public class SumOfLeftLeaves {
    int ans = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        sum(root);
        return ans;
    }

    // If they ask us to give sum of 1st node in every level, then we can go for BFS.
    // We cannot use postorder or preorder. Because, that specific element doesn't know am i the left element or right element.
    // So we use parent element to check the left leaf.
    private void sum(TreeNode node) {
        if(node == null) {
            return;
        }

        if(isLeftLeaf(node.left)) {
            ans += node.left.val;
        }

        sum(node.left);
        sum(node.right);
    }

    private boolean isLeftLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }
}
