package datastructure.tree.problems;

public class SumOfRootToLeafBinaryTree1022 {
    public int sumRootToLeaf(TreeNode root) {
        return sumRoot(root, "");
    }

    private int sumRoot(TreeNode node, String binary) {
        if(node.left == null && node.right == null) {
            return Integer.parseInt(binary + "" + node.val, 2);
        }

        int ans = 0;

        if(node.left != null) {
            ans += sumRoot(node.left, binary + "" + node.val);
        }

        if(node.right != null) {
            ans += sumRoot(node.right, binary + "" + node.val);
        }

        return ans;
    }
}
