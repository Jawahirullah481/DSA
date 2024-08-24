package datastructure.tree.dsa;

import javax.swing.text.Segment;

public class SegmentTree {
    STNode root;

    public static class STNode {
        int value;
        STNode left;
        STNode right;
        int height;

        int stInterval;
        int endInterval;

        public STNode(int value, int stInterval, int endInteval) {
            this.value = value;
            this.stInterval = stInterval;
            this.endInterval = endInteval;
        }

    }

    public void insert(int[] arr) {
        this.root = insert(arr, 0, arr.length - 1);
    }

    private STNode insert(int[] arr, int st, int end) {

        STNode node = new STNode(0, st, end);
        if(st >= end) {
            node.value = arr[st];
            node.stInterval = st;
            node.endInterval = end;
            return node;
        }

        int mid = (st + end) / 2;
        node.left = insert(arr, st, mid);
        node.right = insert(arr, mid + 1, end);

        node.value = node.left.value + node.right.value;
        return node;
    }

    public void prettyDisplay() {
        prettyDisplay(root, 0);
    }

    private void prettyDisplay(STNode node, int level) {
        if(node == null) {
            return;
        }

        prettyDisplay(node.left, level + 1 );
        if(level == 0) {
            System.out.printf("%d [%d, %d]", node.value, node.stInterval, node.endInterval);
        } else {
            for(int i = 1; i <= level; i++) {
                System.out.print("|\t\t\t");
            }
            System.out.printf("-------->%d [%d, %d]\n", node.value, node.stInterval, node.endInterval);
        }
        prettyDisplay(node.right, level + 1);
    }

    public static void main(String[] args) {
        SegmentTree tree = new SegmentTree();
        tree.insert(new int[] {1, 2, 3, 4, 5, 6, 7});
        tree.prettyDisplay();
    }
}
