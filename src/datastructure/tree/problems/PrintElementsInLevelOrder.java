package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PrintElementsInLevelOrder {
    // Given the root of a binary tree,
    // return the level order traversal of its nodes' values.
    // (i.e., from left to right, level by level).

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> container = new ArrayList<>();
        if(root == null) {
            return container;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>(levelSize);
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            container.add(list);
        }

        return container;
    }
}
