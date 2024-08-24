package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

public class KthSmallestNodeInBST {
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        if(root == null) {
            return 0;
        }

        int left = kthSmallest(root.left, k);
        if(count == k) {
            return left;
        }

        count++;
        if(count == k) {
            return root.val;
        }

        int right = kthSmallest(root.right, k);
        if(count == k) {
            return right;
        }

        return root.val;

    }
}
