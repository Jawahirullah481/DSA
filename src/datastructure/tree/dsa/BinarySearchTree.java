package datastructure.tree.dsa;

public class BinarySearchTree {
    private Node root;

    private int height(Node node) {
        if(node == null) {
            return - 1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    private void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if(node == null) {
            Node newNode = new Node(value);
            return newNode;
        }
        if(value < node.value) {
            node.left = insert(value, node.left);
        }
        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    public void populate(int[] arr) {
        for(int i : arr) {
            insert(i);
        }
    }

    public void display() {
        BinaryTree.prettyDisplay(root);
    }

    public void populateSorted(int[] arr) {
        populateSorted(0, arr.length, arr);
    }

    public void populateSorted(int st, int end, int[] arr) {
        if(st >= end) {
            return;
        }
        int mid = (st + end) / 2;
        this.insert(arr[mid]);
        populateSorted(st, mid, arr);
        populateSorted(mid + 1, end, arr);
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        //tree.populate(new int[] {5, 2, 1, 4, 7});
        tree.populateSorted(new int[] {1, 2, 3, 4, 5, 6, 7});
        tree.display();
    }

}
