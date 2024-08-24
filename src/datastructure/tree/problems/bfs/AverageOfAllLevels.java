package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfAllLevels {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();

        if(root == null) {
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            double sum = 0.0;
            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                sum += node.val;

                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
            double average = sum / levelSize;
            list.add(average);
        }

        return list;
    }
}
