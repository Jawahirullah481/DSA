package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ZigZagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offerFirst(root);

        boolean isReverse = false;

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> inner = new ArrayList<>();
            for(int i = 0; i < levelSize; i++) {
                if(!isReverse) {
                    TreeNode node = queue.pollFirst();
                    inner.add(node.val);
                    if(node.left != null) {
                        queue.offerLast(node.left);
                    }
                    if(node.right != null) {
                        queue.offerLast(node.right);
                    }
                } else {
                    TreeNode node = queue.pollLast();
                    inner.add(node.val);
                    if(node.right != null) {
                        queue.offerFirst(node.right);
                    }
                    if(node.left != null) {
                        queue.offerFirst(node.left);
                    }
                }
            }
            list.add(inner);
            isReverse = !isReverse;
        }

        return list;
    }
}
