package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return findSum(root, "");
    }

    private int findSum(TreeNode node, String num) {

        if(node == null) {
            return 0;
        }

        num = num + "" + node.val;

        int leftSum = findSum(node.left, num);
        int rightSum = findSum(node.right, num);

        int total = leftSum + rightSum;

        if(total == 0) {
            return Integer.parseInt(num);
        }

        return leftSum + rightSum;
    }
}
