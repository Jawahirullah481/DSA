package datastructure.tree.problems;

import datastructure.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideNodesOfTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            TreeNode rightMost = queue.peek();
            list.add(rightMost.val);

            int levelSize = queue.size();
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.right != null) {
                    queue.offer(node.right);
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
            }
        }

        return list;
    }
}
