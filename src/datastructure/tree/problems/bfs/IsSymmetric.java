package datastructure.tree.problems.bfs;

import datastructure.tree.problems.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            List<Integer> inner = new ArrayList<>();
            int levelSize = queue.size();

            for(int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                if(node.left != null) {
                    queue.offer(node.left);
                    inner.add(node.left.val);
                } else {
                    inner.add(null);
                }

                if(node.right != null) {
                    queue.offer(node.right);
                    inner.add(node.right.val);
                } else {
                    inner.add(null);
                }
            }

            boolean isSymmetric = checkIsSymmetric(inner);
            if(!isSymmetric) {
                return false;
            }
        }

        return true;
    }

    private boolean checkIsSymmetric(List<Integer> list) {
        System.out.println(list);
        for(int i = 0; i < list.size() / 2; i++) {
            if(list.get(i) != list.get(list.size() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
