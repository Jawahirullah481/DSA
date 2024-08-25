package datastructure.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

public class CreateLinkedList {
    private static class TNode {
        public int val;
        public TNode left;
        public TNode right;
        public TNode next;

        public TNode() {}

        public TNode(int _val) {
            val = _val;
        }

        public TNode(int _val, TNode _left, TNode _right, TNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    private TNode solution1(TNode root) {
        if(root == null) {
            return root;
        }

        Queue<TNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            queue.offer(null);

            for(int i = 0; i < levelSize; i++) {
                TNode node = queue.poll();
                node.next = queue.peek();
                if(queue.size() > 0 && queue.peek() == null) {
                    queue.poll();
                }
                if(node.left != null) {
                    queue.offer(node.left);
                }
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return root;
    }

    private TNode solution2(TNode root) {
        if(root == null) {
            return root;
        }

        TNode leftMost = root;

        while(leftMost != null) {
            TNode current = leftMost;
            while(current != null) {

                // In perfect binary tree, if left TNode is avail, then right TNode also avail.
                if(current.left != null) {
                    current.left.next = current.right;
                }

                if(current.right != null && current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }
}
