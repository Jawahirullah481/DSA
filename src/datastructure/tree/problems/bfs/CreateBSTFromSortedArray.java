package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

public class CreateBSTFromSortedArray {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int st, int end) {

        if (st > end) {
            return null;
        }

        int mid = (st + end) / 2;

        TreeNode node = new TreeNode();
        node.val = nums[mid];
        node.left = buildTree(nums, st, mid - 1);
        node.right = buildTree(nums, mid + 1, end);

        return node;
    }
}
